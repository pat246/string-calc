/**
 * 
 */
package com.capita.stringcalc.operator;

import com.capita.stringcalc.constant.Precedence;

/**
 * @author Prashant
 *
 */
public class RightBrace extends SymbolicOperator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getSymbol()
	 */
	public Symbol getSymbol() {
		return Symbol.BRACE_RIGHT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getPrecedence()
	 */
	public Precedence getPrecedence() {
		return Precedence.P1;
	}

}
