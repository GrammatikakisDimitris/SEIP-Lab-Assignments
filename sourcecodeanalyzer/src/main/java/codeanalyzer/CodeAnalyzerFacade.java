package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeAnalyzerFacade {
	
	private SourceCodeAnalyzer analyzer;
	private MetricsExporter exporter;

	public void analyze(String filepath, String sourceCodeAnalyzerType,
			String sourceFileLocation, String outputFilePath, String outputFileType) throws IOException {
		
		analyzer = new SourceCodeAnalyzer(sourceFileLocation);
		int loc = analyzer.analyzeSourceCode("LOC", filepath, sourceCodeAnalyzerType);
		int nom = analyzer.analyzeSourceCode("NOM", filepath, sourceCodeAnalyzerType);
		int noc = analyzer.analyzeSourceCode("NOC", filepath, sourceCodeAnalyzerType);
		 
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);
				
		exporter = new MetricsExporter();
		exporter.writeFile(outputFileType, metrics, outputFilePath);
	}

	
}
