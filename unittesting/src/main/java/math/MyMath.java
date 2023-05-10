package math;

/**

This class contains a method to calculate the factorial of a given integer.
*/

public class MyMath {
	
	/**
	 * Calculates the factorial of the given integer.
	 * @param n the integer to calculate the factorial for
	 * @return the factorial of the given integer
	 * @throws IllegalArgumentException if the given integer is negative or greater than 12 (as the result would exceed the range of int)
	 */
	public int factorial(int n) throws IllegalArgumentException{
		if(n < 0 || n > 12) throw new IllegalArgumentException("number should be >= 0 and <= 12");
		
		if(n == 0) {
			return 1;
		
		} else {
			return n*factorial(n-1);
		}
	}
}
