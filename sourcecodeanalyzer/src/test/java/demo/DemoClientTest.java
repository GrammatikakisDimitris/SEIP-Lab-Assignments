package demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DemoClientTest {

	DemoClient dc = new DemoClient();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testValidArguments() throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		String[] args = {filepath, sourceCodeAnalyzerType, sourceFileLocation,
				outputFilePath, outputFileType};
		
		dc.main(args);
		
		Assert.assertEquals(dc.getArguments().length, 5);
	}
	
	@Test
	public void testInvalidArguments() throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		
		String[] args = {filepath};
		
		thrown.expectMessage("Incorrect number of arguments.");
		dc.main(args);
	}
}
