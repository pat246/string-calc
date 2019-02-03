package com.capita.stringcalc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capita.stringcalc.exception.OperationNotSupportedException;
import com.capita.stringcalc.exception.OperatorNotDefinedException;
import com.capita.stringcalc.operator.Operator;

/**
 * Main application for String expression calculator
 * <p>
 * Assumptions: <br>
 * 1. Operands are integers numbers from 0 to 9 <br>
 * 2. No spaces allowed in expression<br>
 * </p>
 * 
 * @author Prashant
 *
 */
public class App {
	public static void main(String[] args) throws OperatorNotDefinedException, OperationNotSupportedException,
			InstantiationException, IllegalAccessException {
		Scanner scanIn = new Scanner(System.in);
		int T = Integer.parseInt(scanIn.nextLine().toString());
		List<String> expressions = new ArrayList<String>();
		for (int i = 0; i < T; i++) {
			expressions.add(scanIn.nextLine());
		}
		Operator.buildSymbolMap();
		int i = 1;
		for (String expression : expressions) {
			if (ExpressionService.isValidExpression(expression)) {
				Double result = new ExpressionService().eval(expression);
				DecimalFormat df = new DecimalFormat("#.##");
				System.out.println(String.format("Case #%s: %s", i, df.format(result)));
			} else {
				System.out.println(String.format("Case #%s: INVALID EXPRESSION", i));
			}
			i++;
		}
		scanIn.close();
	}
}
