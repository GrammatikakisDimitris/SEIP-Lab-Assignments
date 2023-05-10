package math;

/**

This class contains JUnit test cases for the ArithmeticOperations class.
*/

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class ArithmeticOperationsTest {
	
	ArithmeticOperations ao = new ArithmeticOperations();
	
	/**
	 * Test case for divide method. Expects an ArithmeticException to be thrown when denominator is 0.
	 */
	
	@Test (expected = ArithmeticException.class)
	public void test_divide() {
		double numerator = 10.0;
		double denominator = 2.0;
		
		double expected = 5.0;
		Assert.assertEquals(expected, ao.divide(numerator, denominator), 0);
		
		denominator = 0;
		double result = ao.divide(numerator, denominator);
	}
	
	/**
	 * Test case for multiply method. Expects IllegalArgumentException to be thrown when x or y is negative,
	 * and expects an ArithmeticException to be thrown when the product does not fit in an Integer variable.
	 */
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_multiply() {
		int x = 2;
		int y = 5;
		
		double expected = 10;
		Assert.assertEquals(expected, ao.multiply(x, y), 0);
		
		x = -1;
		y = -2;
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(x, y);
		
		x = Integer.MAX_VALUE + 1;
		y = 2;
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(x, y);
	}
}
