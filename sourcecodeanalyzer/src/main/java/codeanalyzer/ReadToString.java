package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadToString implements MyFileReader {
		
	/**
	 * Reads a file and returns its content in a single String
	 * @param fileReaderType the location of a file 
	 * (<b>local</b> for locally stored files, 
	 * <b>web</b> for files stored on the web). 
	 * @param filepath the url of the file
	 * @return a String that contains the contents of the file
	 * or null if the type is neither <b>local</b> nor <b>web</b>
	 * @throws IOException
	 */
	@Override
	public String readFile(String type, String filepath) throws IOException {
		// read a locally stored file
		if (type.contentEquals("local")) {
			StringBuilder sb = new StringBuilder();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			return sb.toString();
		// read a file stored in the web
		} else if (type.contentEquals("web")) {
			StringBuilder sb = new StringBuilder();
	        URL url = new URL(filepath);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	sb.append(line + "\n");
	        }
	        reader.close();
			return sb.toString();
		} else {
			return null;
		}
	}

}
