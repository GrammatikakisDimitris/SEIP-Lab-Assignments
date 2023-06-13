package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web.
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 *
 */
public class SourceFileReader {
	
	private String type;
	
	public SourceFileReader(String _type) {
		this.type = _type;
	}
	
	private ReadToList list = new ReadToList();
	private ReadToString string = new ReadToString();
	
	public <T> T readSourceFile(String readType, String filepath) throws IOException {
		if(readType.equals("List")) {
			return (T) list.readFile(type, filepath);
		} else if(readType.equals("String")) {
			String result = string.readFile(type, filepath);
			return (T) result;
		} else {
			throw new IllegalArgumentException("Unknown type : " + readType);
		}
	}

	

}
