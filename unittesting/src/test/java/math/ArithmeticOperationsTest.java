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
	 * Test cases for the divide method. Expect an ArithmeticException to be thrown when denominator is 0.
	 */
	
	@Test
	public void testDivideValidInput() {
		double numerator = 10.0;
		double denominator = 2.0;
		
		double expected = 5.0;
		Assert.assertEquals(expected, ao.divide(numerator, denominator), 0);
		
	}
	
	@Test (expected = ArithmeticException.class)
	public void testDivideByZero() {
		double numerator = 10.0;
		double denominator = 0;
		
		double result = ao.divide(numerator, denominator);
		System.out.println("Cannot divide with zero");
	}
	
	
	/**
	 * Test case for multiply method. Expects IllegalArgumentException to be thrown when x or y is negative,
	 * and expects an ArithmeticException to be thrown when the product does not fit in an Integer variable.
	 */
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testMultiplyValidInput() {
		int x = 2;
		int y = 5;
		
		int expected = 10;
		Assert.assertEquals(expected, ao.multiply(x, y), 0);
	}
	
	@Test
	public void testMultiplyZeroInputXY() {		
		int x = 0;
		int y = 0;
		
		int expected = 0;
		Assert.assertEquals(expected, ao.multiply(x, y), 0);
	}
	
	@Test
	public void testMultiplyZeroInputX() {		
		int x = 0;
		int y = 5;
		
		int expected = 0;
		Assert.assertEquals(expected, ao.multiply(x, y), 0);
	}
	
	@Test
	public void testMultiplyZeroInputY() {		
		int x = 10;
		int y = 0;
		
		int expected = 0;
		Assert.assertEquals(expected, ao.multiply(x, y), 0);
	}
	
	@Test
	public void testMultiplyNegativeInputXY() {		
		int x = -1;
		int y = -2;
		
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(x, y);
	}
	
	@Test
	public void testMultiplyNegativeInputX() {		
		int x = -1;
		int y = 2;
		
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(x, y);
	}
	
	@Test
	public void testMultiplyNegativeInputY() {		
		int x = 1;
		int y = -2;
		
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(x, y);
	}
	
	
	@Test
	public void testMultiplyIntegerOutOfBounds() {
		int x = Integer.MAX_VALUE - 1;
		int y = 2;
		
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(x, y);
	}
}
