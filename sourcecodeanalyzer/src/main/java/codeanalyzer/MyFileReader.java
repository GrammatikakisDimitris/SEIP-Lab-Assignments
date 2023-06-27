package codeanalyzer;

import java.io.IOException;
import java.util.List;

public interface MyFileReader {
	
	public <T> T readFile(String type, String filepath) throws IOException;

}
