package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateNOM implements MetricCalculator{
	
	@Override
	public int calculateMetric(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		if(analyzerType.equals("regex")) {
			String sourceCode = fileReader.readSourceFile("String", filepath);
			Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	        Matcher methodSignatures = pattern.matcher(sourceCode);

	        int methodCounter = 0;
	        while (methodSignatures.find()) {
	        	methodCounter++;
	        }
			return methodCounter;
		} else if (analyzerType.equals("strcomp")) {
			List<String> sourceCodeList = fileReader.readSourceFile("List", filepath);
			int methodCounter = 0;
			for (String line : sourceCodeList) {
				line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
				if ((line.contains("void") || line.contains("int") || line.contains("String"))
					&& line.contains("(") && line.contains(")") && line.contains("{") )
					methodCounter++;
			}
			return methodCounter; 
		}
		return -1;
	}
}
