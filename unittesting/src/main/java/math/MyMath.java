package math;

/**

This class contains a method to calculate the factorial of a given integer
and a method to calculate whether an integer is prime or not.
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
		
	/**
     * Checks if the given number is prime.
     *
     * @param n the number to be checked
     * @return {@code true} if the number is prime, {@code false} otherwise
     * @throws IllegalArgumentException if the number is less than 2
     */
	public boolean isPrime(int n) {
		if (n < 2) {
			throw new IllegalArgumentException("number should be >= 2");
        }

        // Check for divisibility from 2 to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Not prime, as it has a divisor other than 1 and itself
            }
        }

        return true; // Prime number
	}
}
