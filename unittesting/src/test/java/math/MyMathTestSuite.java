package math;

/**

The MyMathTestSuite class is a test suite that runs the MyMathTest and MyMathParameterizedTest classes as a group using
JUnit 4 testing framework. 
This class uses the @RunWith and @Suite annotations to specify the test runner and the classes
that should be included in the test suite.
*/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathParameterizedTest.class})
public class MyMathTestSuite {

}
