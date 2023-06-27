package codeanalyzer;

import java.util.Map;

public interface MetricExporter {
	
	public void writeFile(Map<String, Integer> metrics, String filepath);

}
