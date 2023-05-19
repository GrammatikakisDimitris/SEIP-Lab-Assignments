package math;

/**

This class contains JUnit test cases for the MyMath class.
*/

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

public class MyMathTest {
	
	MyMath mm = new MyMath();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Tests the factorial() method of the MyMath class for normal and exceptional cases.
	 * Expects an exception to be thrown when the input is a negative integer or an integer greater than 12.
	 */
	
	@Test
	public void testFactorial() {
		int number = 4;
		
		int expected = 24;
		Assert.assertEquals(expected, mm.factorial(number));
		
		number = -1;
		thrown.expectMessage("number should be >= 0 and <= 12");
		mm.factorial(number);
		
		number = 13;
		thrown.expectMessage("number should be >= 0 and <= 12");
		mm.factorial(number);
	}
	
	/**
     * Test case for the isPrime() method of the MyMath class.
     * Tests the primality check for a positive integer.
     * Expects an exception to be thrown when the input is less than 2.
     */
	@Test
	public void testIsPrime() {
		int number = 5;
		
		boolean expected = true;
		Assert.assertEquals(expected, mm.isPrime(number));
		
		number = 0;
		thrown.expectMessage("number should be >= 2");
		mm.isPrime(number);
	}
}

