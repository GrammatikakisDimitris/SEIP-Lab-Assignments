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
}

