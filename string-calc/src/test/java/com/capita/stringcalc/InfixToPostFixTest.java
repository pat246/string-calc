package com.capita.stringcalc;

import com.capita.stringcalc.exception.OperationNotSupportedException;
import com.capita.stringcalc.exception.OperatorNotDefinedException;

import junit.framework.TestCase;

/**
 * ExpressionService test
 * 
 * @author Prashant
 *
 */
public class InfixToPostFixTest extends TestCase {

	public void testInfixToPostFixExpression()
			throws OperatorNotDefinedException, InstantiationException, IllegalAccessException {
		ExpressionService service = new ExpressionService();
		String result = service.convertToPostfixExpression("1/0");
		assertEquals("10/", result);

		result = service.convertToPostfixExpression("(1+2)");
		assertEquals("12+", result);

		result = service.convertToPostfixExpression("7+(6*5^2+3-4/2)");
		assertEquals("7652^*3+42/-+", result);
	}
}
