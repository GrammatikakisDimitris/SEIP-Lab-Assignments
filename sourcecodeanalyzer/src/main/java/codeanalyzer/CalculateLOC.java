package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateLOC implements MetricCalculator{

	@Override
	public int calculateMetric(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		if(analyzerType.equals("regex")) {
			String sourceCode = fileReader.readSourceFile("String", filepath);
			Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
	        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

	        int nonCodeLinesCounter = 0;
	        while (nonCodeLinesMatcher.find()) {
	        	nonCodeLinesCounter++;
	        }
			
	        int sourceFileLength = sourceCode.split("\n").length;
	        int loc =  sourceFileLength - nonCodeLinesCounter;
	        
			return loc;
		} else if (analyzerType.equals("strcomp")) {
			List<String> sourceCodeList = fileReader.readSourceFile("List", filepath);
			int nonCodeLinesCounter = 0;
			for (String line : sourceCodeList) {
				line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
				if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("}") || line.equals(""))
					nonCodeLinesCounter++;
			}
			int loc = sourceCodeList.size() - nonCodeLinesCounter;
			return loc; 
		}
		return -1;
	}
	
	

}
