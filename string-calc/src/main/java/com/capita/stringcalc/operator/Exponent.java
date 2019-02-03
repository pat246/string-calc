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
public class Exponent implements Operator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#operate(java.lang.Double,
	 * java.lang.Double)
	 */
	public Double operate(Double a, Double b) {
		return Math.pow(a, b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getSymbol()
	 */
	public Symbol getSymbol() {
		return Symbol.EXPONENT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getPrecedence()
	 */
	public Precedence getPrecedence() {
		return Precedence.P2;
	}

}
