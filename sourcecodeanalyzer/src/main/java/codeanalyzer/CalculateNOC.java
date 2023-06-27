package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateNOC implements MetricCalculator {
	
	@Override
	public int calculateMetric(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		if(analyzerType.equals("regex")) {
			String sourceCode = fileReader.readSourceFile("String", filepath);
			Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
	        Matcher classSignatures = pattern.matcher(sourceCode);

	        int classCounter = 0;
	        while (classSignatures.find()) {
	        	classCounter++;
	        }
			return classCounter;
		} else if (analyzerType.equals("strcomp")) {
			List<String> sourceCodeList = fileReader.readSourceFile("List", filepath);
			int classCounter = 0;
			for (String line : sourceCodeList) {
				line = line.strip(); //remove leading and trailing white spaces
				if ((line.startsWith("class ") || line.contains(" class "))) {
					classCounter++;
				}
			}
			return classCounter; 
		}
		return -1;
	}

}
