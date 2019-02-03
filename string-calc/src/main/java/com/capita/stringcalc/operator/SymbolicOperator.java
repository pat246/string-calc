/**
 * 
 */
package com.capita.stringcalc.operator;

import com.capita.stringcalc.exception.OperationNotSupportedException;

/**
 * Represents operators which are used only as symbols
 * 
 * @author Prashant
 *
 */
public abstract class SymbolicOperator implements Operator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#operate(java.lang.Double,
	 * java.lang.Double)
	 */
	public Double operate(Double arg1, Double arg2) throws OperationNotSupportedException {

		throw new OperationNotSupportedException(this, arg1, arg2);
	}

}
