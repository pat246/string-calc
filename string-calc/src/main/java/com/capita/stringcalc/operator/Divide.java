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
public class Divide implements Operator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#operate(java.lang.Double,
	 * java.lang.Double)
	 */
	public Double operate(Double a, Double b) throws OperationNotSupportedException {
		if (b.equals(new Double(0))) {
			throw new OperationNotSupportedException(this, a, b);
		}
		return a / b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getSymbol()
	 */
	public Symbol getSymbol() {
		return Symbol.DIVID;
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
