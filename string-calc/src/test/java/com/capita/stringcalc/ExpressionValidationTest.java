package com.capita.stringcalc;

import com.capita.stringcalc.exception.OperationNotSupportedException;
import com.capita.stringcalc.exception.OperatorNotDefinedException;

import junit.framework.TestCase;

/**
 * Test to validate expressions
 * 
 * @author Prashant
 *
 */
public class ExpressionValidationTest extends TestCase {

	public void testValidExpressions() {
		boolean result = ExpressionService.isValidExpression("1+23");
		assertEquals(false, result);

		result = ExpressionService.isValidExpression("8*+7");
		assertEquals(false, result);

		result = ExpressionService.isValidExpression("8+7");
		assertEquals(true, result);

		result = ExpressionService.isValidExpression("(8*5/8)-(3/1)-5");
		assertEquals(true, result);

		result = ExpressionService.isValidExpression("7+(67(56*2))");
		assertEquals(false, result);

	}
	

}
