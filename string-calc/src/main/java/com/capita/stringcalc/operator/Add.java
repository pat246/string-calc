/**
 * 
 */
package com.capita.stringcalc.operator;

import com.capita.stringcalc.constant.Precedence;

/**
 * @author Prashant
 *
 */
public class Add implements Operator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#operate(java.lang.Double,
	 * java.lang.Double)
	 */
	public Double operate(Double a, Double b) {
		return a + b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getSymbol()
	 */
	public Symbol getSymbol() {
		return Symbol.ADD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getPrecedence()
	 */
	public Precedence getPrecedence() {
		return Precedence.P4;
	}

}
