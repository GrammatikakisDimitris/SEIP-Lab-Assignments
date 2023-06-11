package io;

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/**
 * JUnit test class for the FileIO class.
 */
public class FileIOTest {
	
	FileIO fileio = new FileIO();
	
	/**
     * Rule to handle expected exceptions in tests.
     */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
     * Test case for reading a valid input file.
     * Expected behavior: The file is read successfully and the array of numbers matches the expected_numbers array.
     */
	@Test
	public void testReadValidInput() {
		int [] expected_numbers = new int [] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		String validInputFilePath = "src/test/resources/numbers.txt";
		
		Assert.assertArrayEquals(expected_numbers, fileio.readFile(validInputFilePath));

	}
	
	 /**
     * Test case for reading a non-existent file.
     * Expected behavior: An IllegalArgumentException is thrown with the message "Input file does not exist".
     */
	@Test
	public void testReadWrongFile() {
		
		String validInputFilePath = "src/test/resources/grades.txt";
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		
		fileio.readFile(validInputFilePath);
	}
	
	/**
     * Test case for reading an empty file.
     * Expected behavior: An IllegalArgumentException is thrown with the message "Given file is empty".
     */
	@Test 
	public void testReadEmptyFile() {
		
		String validInputFilePath = "src/test/resources/empty.txt";
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		
		fileio.readFile(validInputFilePath);
	}
	
	/**
     * Test case for reading a file containing invalid entries.
     * Expected behavior: The file is read successfully, but the invalid entries are not processed.
     */
	@Test
	public void testReadFileContainsInvalidEntries() {
		
		String validInputFilePath = "src/test/resources/invalid_values.txt";
		
		fileio.readFile(validInputFilePath);
	}

}