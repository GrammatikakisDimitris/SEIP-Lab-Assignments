package math;

import io.FileIO;

/**
 * The ArrayOperations class provides operations related to arrays.
 */
public class ArrayOperations {
	
	/**
	 * Finds prime numbers in a file.
	 * 
	 * @param file The FileIO object used to read the file.
	 * @param filepath The path of the file to be read.
	 * @param mymath The MyMath object used to check if a number is prime.
	 * @return An array containing the prime numbers found in the file.
	 */
	public int[] findPrimesInFile(FileIO file, String filepath, MyMath mymath) {
		int[] numbers = file.readFile(filepath);
		int[] temp = new int[numbers.length];
		int[] primeNumbers;
		int counter = 0;
		
		for(int number:numbers) {
			if(mymath.isPrime(number)) {
				temp[counter] = number;
				counter++;
			}
		}
		
		primeNumbers = new int[counter];
		counter = 0;
		
		while (temp[counter] != 0) {
			primeNumbers[counter] = temp[counter];
			counter++;
		}
		
		return primeNumbers;
	} 
}