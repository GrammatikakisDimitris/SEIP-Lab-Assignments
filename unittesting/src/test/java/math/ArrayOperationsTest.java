package math;

import org.junit.Assert;
import org.junit.Test;
import io.FileIO;

import static org.mockito.Mockito.*;

/**
 * Unit tests for the ArrayOperations class using Mockito for mocking dependencies.
 */

public class ArrayOperationsTest {
	
	ArrayOperations ao = new ArrayOperations();
	
	/**
	 * Tests the findPrimesInFile() method by mocking the dependencies.
	 */
	
	@Test
	public void testFindPrimesInFileMocking() {
		
		MyMath mm = mock(MyMath.class);
		FileIO file = mock(FileIO.class);
		
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		when(file.readFile("src/test/resources/numbers.txt")).thenReturn(numbers);
		
		when(mm.isPrime(1)).thenReturn(false);
		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(3)).thenReturn(true);
		when(mm.isPrime(4)).thenReturn(false);
		when(mm.isPrime(5)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);
		when(mm.isPrime(7)).thenReturn(true);
		when(mm.isPrime(8)).thenReturn(false);
		when(mm.isPrime(9)).thenReturn(false);
		when(mm.isPrime(10)).thenReturn(false);
		
		
		Assert.assertArrayEquals(new int[] {2, 3, 5, 7}, ao.findPrimesInFile(file, "src/test/resources/numbers.txt", mm));
		
	}
}
