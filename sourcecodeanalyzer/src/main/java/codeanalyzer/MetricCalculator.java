package codeanalyzer;

public interface MetricCalculator {
	
	public int calculateMetric(String filepath, String analyzerType, SourceFileReader fileReader) throws Exception;

}
