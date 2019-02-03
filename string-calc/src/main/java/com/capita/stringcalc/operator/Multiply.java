/**
 * 
 */
package com.capita.stringcalc.operator;

import com.capita.stringcalc.constant.Precedence;
import com.capita.stringcalc.exception.OperationNotSupportedException;

/**
 * @author Prashant
 *
 */
public class Multiply implements Operator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#operate(java.lang.Double,
	 * java.lang.Double)
	 */
	public Double operate(Double a, Double b) {
		return a * b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getSymbol()
	 */
	public Symbol getSymbol() {
		return Symbol.MULTIPLY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getPrecedence()
	 */
	public Precedence getPrecedence() {
		return Precedence.P3;
	}

}
