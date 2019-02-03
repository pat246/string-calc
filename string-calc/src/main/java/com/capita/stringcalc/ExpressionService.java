package com.capita.stringcalc;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.capita.stringcalc.exception.OperationNotSupportedException;
import com.capita.stringcalc.exception.OperatorNotDefinedException;
import com.capita.stringcalc.operator.Operator;
import com.capita.stringcalc.operator.Symbol;

/**
 * Service class for expression
 * 
 * @author Prashant
 *
 */
public class ExpressionService {

	private Stack<Character> stack1 = new Stack<>();

	private Stack<Double> stack2 = new Stack<>();

	/**
	 * Whether expression is valid or not
	 * 
	 * @param expression
	 * @return true or false
	 */
	public static boolean isValidExpression(String expression) {
		Symbol[] symbols = Symbol.values();
		List<String> symbolList = Arrays.asList(symbols).stream().map(i -> i.getValue() + "")
				.collect(Collectors.toList());
		List<String> symbolListWithoutBrace = Arrays.asList(symbols).stream().filter(i -> {
			if (i.equals(Symbol.BRACE_LEFT)) {
				return false;
			}
			if (i.equals(Symbol.BRACE_RIGHT)) {
				return false;
			}
			return true;
		}).map(i -> i.getValue() + "").collect(Collectors.toList());
		String startRegex = "^(\\d|[\\(]+\\d).*";
		String endRegex = ".*\\d[\\)]*$";
		String validCharactorsRegex = "^([0-9]|[" + String.join("\\", symbolList) + "])+";
		String negativeMatchRegex = ".*(?!\\)\\))(?!\\(\\()[" + String.join("\\", symbolListWithoutBrace) + "]{2,}.*";
		String negativeMatchRegexForConseqOperand = ".*\\d{2,}.*";
		Matcher matcher = Pattern.compile(startRegex).matcher(expression);
		if (!matcher.matches()) {
			return false;
		}
		matcher = Pattern.compile(validCharactorsRegex).matcher(expression);
		if (!matcher.matches()) {
			return false;
		}
		matcher = Pattern.compile(endRegex).matcher(expression);
		if (!matcher.matches()) {
			return false;
		}
		matcher = Pattern.compile(negativeMatchRegex).matcher(expression);
		if (matcher.matches()) {
			return false;
		}
		matcher = Pattern.compile(negativeMatchRegexForConseqOperand).matcher(expression);
		if (matcher.matches()) {
			return false;
		}
		if (!isParenthesisMatch(expression)) {
			return false;
		}
		return true;
	}

	/**
	 * evaluate infix expression
	 * 
	 * @param infixExpression
	 * @return result of evaluation
	 * @throws OperatorNotDefinedException
	 * @throws OperationNotSupportedException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public Double eval(String infixExpression) throws OperatorNotDefinedException, OperationNotSupportedException,
			InstantiationException, IllegalAccessException {
		String postFixExpression = convertToPostfixExpression(infixExpression);
		char[] charArray = postFixExpression.toCharArray();
		int i = 0;
		while (i < charArray.length) {
			Character c = charArray[i];
			if (isOperand(c)) {
				stack2.push(Double.parseDouble(c.toString()));
			} else {
				Double arg2 = Double.parseDouble(stack2.pop().toString());
				Double arg1 = Double.parseDouble(stack2.pop().toString());
				Operator operator = Operator.getInstance(c);
				stack2.push(operator.operate(arg1, arg2));
			}
			i++;
		}
		return stack2.pop();
	}

	/**
	 * Convert infix to postfix expression
	 * 
	 * @param infixExpression
	 * @return
	 * @throws OperatorNotDefinedException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public String convertToPostfixExpression(String infixExpression)
			throws OperatorNotDefinedException, InstantiationException, IllegalAccessException {
		StringBuffer postFixExpression = new StringBuffer();

		char[] charArray = infixExpression.toCharArray();
		int i = 0;
		while (i < charArray.length) {
			Character c = charArray[i];
			if (isOperand(c)) {
				postFixExpression.append(charArray[i]);
			}
			if (c == '(') {
				stack1.push(c);
			}
			if (c == ')') {
				while (!stack1.isEmpty() && stack1.peek().charValue() != '(') {
					postFixExpression.append(stack1.pop());
				}
				stack1.pop();
			}
			if (isOperator(c)) {
				if (stack1.isEmpty() || (stack1.peek().charValue() == '(')) {
					stack1.push(c);
				} else {
					while (!stack1.isEmpty() && stack1.peek().charValue() != '('
							&& hasLessPrecedance(c, stack1.peek().charValue())) {
						postFixExpression.append(stack1.pop());
					}
					stack1.push(c);
				}
			}
			i++;
		}
		while (!stack1.isEmpty()) {
			postFixExpression.append(stack1.pop());
		}
		stack1.clear();
		return postFixExpression.toString();
	}

	/**
	 * Whether operator represented by c1 has less precedence over c2
	 * 
	 * @param c1
	 * @param c2
	 * @return true or false
	 * @throws OperatorNotDefinedException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private boolean hasLessPrecedance(Character c1, Character c2)
			throws OperatorNotDefinedException, InstantiationException, IllegalAccessException {
		Operator op1 = Operator.getInstance(c1);
		Operator op2 = Operator.getInstance(c2);
		return op1.getPrecedence().getValue().compareTo(op2.getPrecedence().getValue()) >= 0;
	}

	private boolean isOperator(char c) {
		List<Character> allSymbolicCharacters = Arrays.asList(Symbol.values()).stream().filter(i -> {
			if (i.equals(Symbol.BRACE_LEFT)) {
				return false;
			}
			if (i.equals(Symbol.BRACE_RIGHT)) {
				return false;
			}
			return true;
		}).map(i -> i.getValue()).collect(Collectors.toList());
		for (char ch : allSymbolicCharacters) {
			if (ch == c) {
				return true;
			}
		}
		return false;
	}

	private boolean isOperand(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}

	public static boolean isParenthesisMatch(String str) {
		if (str.charAt(0) == '{')
			return false;

		Stack<Character> stack = new Stack<Character>();

		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			if (c == '(')
				stack.push(c);
			else if (c == '{')
				stack.push(c);
			else if (c == ')')
				if (stack.empty())
					return false;
				else if (stack.peek() == '(')
					stack.pop();
				else
					return false;
			else if (c == '}')
				if (stack.empty())
					return false;
				else if (stack.peek() == '{')
					stack.pop();
				else
					return false;
		}
		return stack.empty();
	}

}
