package math;

import java.util.Collection;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Assert;

/**
 * A parameterized test class for the MyMath class, testing the factorial method.
 */

@RunWith(Parameterized.class)
public class MyMathParameterizedTest {
	
	@Parameter(value = 0)
	public int number;
	@Parameter(value = 1)
	public int result;
	
	MyMath mm = new MyMath();
	

	/**
	 * Provides a collection of test cases for the factorial method.
	 *
	 * @return A collection containing arrays of input and expected output values for the factorial method.
	 */
	
	@Parameters
	public static Collection<Object[]> data(){
		Object [][] data = new Object[][] {{0,1}, {1,1}, {2,2}, {12,479001600}};
		
		return Arrays.asList(data);
	}
	
	/**
	 * Tests the factorial method using the provided parameterized data.
	 */
	
	@Test
	public void testFactorialNormalCases() {
		Assert.assertEquals(result, mm.factorial(number));
	}
}
