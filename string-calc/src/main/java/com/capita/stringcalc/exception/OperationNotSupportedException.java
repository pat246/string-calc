/**
 * 
 */
package com.capita.stringcalc.exception;

import com.capita.stringcalc.operator.Operator;

/**
 * When operator is not supported this exception will be thrown
 * 
 * @author Prashant
 *
 */
public class OperationNotSupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public OperationNotSupportedException(Operator operator, Double arg1, Double arg2) {
		super(String.format("Operation %s not supported for arg1 %s and arg2 %s", operator.getSymbol().name(), arg1,
				arg2));
	}

}
