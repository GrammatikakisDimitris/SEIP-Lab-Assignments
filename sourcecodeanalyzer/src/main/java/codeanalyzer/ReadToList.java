package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadToList implements MyFileReader {
	
	/**
	 * Reads a file and returns its content in a List
	 * @param fileReaderType the location of a file 
	 * (<b>local</b> for locally stored files, 
	 * <b>web</b> for files stored on the web). 
	 * @param filepath the url of the file
	 * @return a List that contains the contents of the file 
	 * or null if the type is neither <b>local</b> nor <b>web</b>
	 * @throws IOException
	 */

	@Override
	public List<String> readFile(String type, String filepath) throws IOException {
		// read a locally stored file
		if (type.contentEquals("local")) {
			List<String> lines = new ArrayList<>();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines;
		// read a file stored in the web
		} else if (type.contentEquals("web")) {
			List<String> lines = new ArrayList<>();
			URL url = new URL(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines;
		} else {
			return null;
		}
		
	}

}
