package com.capita.stringcalc;

import com.capita.stringcalc.exception.OperationNotSupportedException;
import com.capita.stringcalc.exception.OperatorNotDefinedException;

import junit.framework.TestCase;

/**
 * To test infix expression converion into postfix expression
 * 
 * @author Prashant
 *
 */
public class ExpressionServiceTest extends TestCase {

	public void testExpressionEval() throws OperatorNotDefinedException, InstantiationException, IllegalAccessException,
			OperationNotSupportedException {
		ExpressionService service = new ExpressionService();
		Double result = service.eval("(1+2)");
		assertEquals(3.0, result);

		service = new ExpressionService();
		result = service.eval("7+(6*5^2+3-4/2)");
		assertEquals(158.0, result);
	}

}
