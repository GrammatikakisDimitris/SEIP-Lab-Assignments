package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import codeanalyzer.SourceCodeAnalyzer;

import static org.junit.Assert.*;

public class SourceCodeAnalyzerTest {
	private static List<String> testSourceCode;
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_2 = "src/test/resources//TestClass2.java";
	private SourceCodeAnalyzer sca = new SourceCodeAnalyzer("local");
	
	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		assertEquals(21, sca.analyzeSourceCode("LOC", TEST_CLASS, TYPE_REGEX));
	}
	
	@Test
	public void testCalculateStrCompLOC() throws IOException {
		assertEquals(7, sca.analyzeSourceCode("LOC", TEST_CLASS, TYPE_STRCOMP));
	}
	
	@Test
	public void testCalculateInvalidLOC() throws IOException {
		assertEquals(-1, sca.analyzeSourceCode("LOC", TEST_CLASS, "wrong type"));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3, sca.analyzeSourceCode("NOM", TEST_CLASS, TYPE_REGEX));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
		assertEquals(3, sca.analyzeSourceCode("NOM", TEST_CLASS, TYPE_STRCOMP));
	}
	
	@Test
	public void testCalculateInvalidNOM() throws IOException {
		assertEquals(-1, sca.analyzeSourceCode("NOM", TEST_CLASS, "wrong type"));
	}
	
	@Test
	public void testCalculateInvalidNOMTestClass2() throws IOException {
		assertEquals(0, sca.analyzeSourceCode("NOM", TEST_CLASS_2, TYPE_REGEX));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		assertEquals(3, sca.analyzeSourceCode("NOC", TEST_CLASS, TYPE_REGEX));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		assertEquals(3, sca.analyzeSourceCode("NOC", TEST_CLASS, TYPE_STRCOMP));
	}
	
	@Test
	public void testCalculateInvalidNOC() throws IOException {
		assertEquals(-1, sca.analyzeSourceCode("NOC", TEST_CLASS, "wrong type"));
	}
}
