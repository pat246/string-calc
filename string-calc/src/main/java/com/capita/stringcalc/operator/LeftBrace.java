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
public class LeftBrace extends SymbolicOperator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capita.stringcalc.operator.Operator#getSymbol()
	 */
	public Symbol getSymbol() {
		return Symbol.BRACE_LEFT;
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
