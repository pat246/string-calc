/**
 * 
 */
package com.capita.stringcalc.constant;

/**
 * Represent precedence of operators. High integer being highest precedence
 * 
 * @author Prashant
 *
 */
public enum Precedence {

	P1(1.0), P2(2.0), P3(3.0), P4(4.0);
	Double value;
	

	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	private Precedence(Double value) {
		this.value = value;
	}

}
