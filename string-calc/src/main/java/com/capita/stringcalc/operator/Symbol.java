/**
 * 
 */
package com.capita.stringcalc.operator;

/**
 * Represents operator's symbol
 * 
 * @author Prashant
 *
 */
public enum Symbol {

	ADD('+'), SUBSTRACT('-'), DIVID('/'), MULTIPLY('*'), EXPONENT('^'), BRACE_LEFT('('), BRACE_RIGHT(')');
	Character value;

	public Character getValue() {
		return value;
	}

	public void setValue(Character value) {
		this.value = value;
	}

	/**
	 * @param value
	 */
	private Symbol(Character value) {
		this.value = value;
	}

	static Symbol findSymbolByValue(Character value) {
		for (Symbol symbol : Symbol.values()) {
			if (symbol.value.equals(value)) {
				return symbol;
			}
		}
		return null;
	}
}
