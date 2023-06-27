package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison).
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 *
 */
public class SourceCodeAnalyzer {
	
	private SourceFileReader fileReader;
	
	public SourceCodeAnalyzer(String fileReaderType) {
		this.fileReader = new SourceFileReader(fileReaderType);
	}
	
	private CalculateLOC loc = new CalculateLOC();
	private CalculateNOM nom = new CalculateNOM();
	private CalculateNOC noc = new CalculateNOC();
	
	public int analyzeSourceCode(String metric, String filepath, String sourceCodeAnalyzerType) throws IOException{
		if(metric.equals("LOC")) {
			return loc.calculateMetric(filepath, sourceCodeAnalyzerType, fileReader);
		} else if(metric.equals("NOM")) {
			return nom.calculateMetric(filepath, sourceCodeAnalyzerType, fileReader);
		} else {
			return noc.calculateMetric(filepath, sourceCodeAnalyzerType, fileReader);
		}
		
	}
}
