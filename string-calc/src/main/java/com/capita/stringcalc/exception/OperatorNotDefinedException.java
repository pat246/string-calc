/**
 * 
 */
package com.capita.stringcalc.exception;

/**
 * @author Prashant
 *
 */
public class OperatorNotDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public OperatorNotDefinedException(String symbol) {
		super("Operator not defined for symbol: " + symbol);
	}

}
