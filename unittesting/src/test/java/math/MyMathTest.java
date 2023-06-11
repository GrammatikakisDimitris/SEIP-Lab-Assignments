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
	 * Test cases for the factorial() method of the MyMath class for normal and exceptional cases.
	 * Expect an exception to be thrown when the input is a negative integer or an integer greater than 12.
	 */
	
	@Test
	public void testFactorialValidInput() {
		int number = 4;
		
		int expected = 24;
		Assert.assertEquals(expected, mm.factorial(number));

	}
	
	@Test
	public void testFactorialLowerThanZero() {
		int number = -1;
		
		thrown.expectMessage("number should be >= 0 and <= 12");
		mm.factorial(number);

	}
	
	@Test
	public void testFactorialHigherThanTwelve() {
		int number = 13;
		thrown.expectMessage("number should be >= 0 and <= 12");
		mm.factorial(number);
	}
	/**
     * Test cases for the isPrime() method of the MyMath class.
     * Test the primality check for a positive integer.
     * Expect an exception to be thrown when the input is less than 2.
     */
	@Test
	public void testIsPrimeValidInputPrime() {
		int number = 5;
		
		boolean expected = true;
		Assert.assertEquals(expected, mm.isPrime(number));

	}
	
	@Test
	public void testIsPrimeValidInputNonPrime() {
		int number = 9;
		
		boolean expected = false;
		Assert.assertEquals(expected, mm.isPrime(number));
	}
	
	@Test
	public void testIsPrimeLowerThanTWo() {
		int number = 0;
		
		thrown.expectMessage("number should be >= 2");
		mm.isPrime(number);
	}
	
}

