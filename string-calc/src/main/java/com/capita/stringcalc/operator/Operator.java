package com.capita.stringcalc.operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.capita.stringcalc.constant.Precedence;
import com.capita.stringcalc.exception.OperationNotSupportedException;
import com.capita.stringcalc.exception.OperatorNotDefinedException;

/**
 * Operator interface representing the mathematical operations like + ,-, * etc
 * 
 * @author Prashant
 * 
 */
public interface Operator {

	Map<Symbol, Operator> SYMBOL_OPERATOR_MAP = new HashMap<Symbol, Operator>();

	/**
	 * @param arg1
	 *            left argument
	 * @param arg2
	 *            right argument
	 * @return return result of operation a op b
	 * @throws OperationNotSupportedException
	 */
	Double operate(Double arg1, Double arg2) throws OperationNotSupportedException;

	/**
	 * @return symbol representing operator e.g. + for addition
	 */
	Symbol getSymbol();

	/**
	 * @return integer from 1 - 100
	 */
	Precedence getPrecedence();

	/**
	 * factory method to return instance of operator
	 * 
	 * @param symbolChar
	 *            - string representing symbol
	 * @return operator for given symbol
	 * @throws InvalidSymbolException
	 * @throws OperatorNotDefinedException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	static Operator getInstance(Character symbolChar)
			throws OperatorNotDefinedException, InstantiationException, IllegalAccessException {
		if (SYMBOL_OPERATOR_MAP.isEmpty()) {
			buildSymbolMap();
		}
		Operator operator = null;
		Symbol symbol = Symbol.findSymbolByValue(symbolChar);
		operator = SYMBOL_OPERATOR_MAP.get(symbol);

		if (operator == null) {
			throw new OperatorNotDefinedException(symbolChar + "");
		}
		return operator;
	}

	static void buildSymbolMap() throws InstantiationException, IllegalAccessException {
		Reflections reflections = new Reflections("com.capita.stringcalc");
		Set<Class<? extends Operator>> classes = reflections.getSubTypesOf(Operator.class);
		for (Class<? extends Operator> opCls : classes) {
			if (!(opCls.equals(SymbolicOperator.class))) {
				Operator object = opCls.newInstance();
				SYMBOL_OPERATOR_MAP.put(object.getSymbol(), object);
			}
		}
	}
}
