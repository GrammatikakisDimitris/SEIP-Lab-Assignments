package demo;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import codeanalyzer.*;

public class DemoClient {
	
	private static String[] arguments;

	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		arguments = args;
		
		if (arguments.length != 5) {
			throw new IOException("Incorrect number of arguments.");
		
		} else {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
			
			CodeAnalyzerFacade caf = new CodeAnalyzerFacade();
			
			caf.analyze(filepath, sourceCodeAnalyzerType,
					sourceFileLocation, outputFilePath, outputFileType);
			
		}

	}
	
	public static String[] getArguments() {
		return arguments;	
	}

}
