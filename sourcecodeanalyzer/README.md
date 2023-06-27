# Source Code Analyzer

This module, named `sourcecodeanalyzer`, is designed to analyze Java source code using various design patterns. It features a command-line interface for running the application and supports multiple output formats.

## Getting Started

### Building the Executable

To build the executable Java application, use the following command:

```bash
mvn package jacoco:report
```

### Running the Application

To run the executable, execute the following command:

```bash
java -jar "jar-with-dependencies" arg0 arg1 arg2 arg3 arg4
```

The arguments are as follows:

<ul>
    <li>arg0: JavaSourceCodeInputFile (e.g., src/test/resources/TestClass.java)</li>
    <li>arg1: sourceCodeAnalyzerType [regex|strcomp]</li>
    <li>arg2: SourceCodeLocationType [local|web]</li>
    <li>arg3: OutputFilePath (e.g., ../output_metrics_file)</li>
    <li>arg4: OutputFileType [csv|json]</li>
</ul>

#### Example:

```bash
java -jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```

## Class Diagram

Download `Class diagram.drawio` from this module and open it in diagrams.net

## Design Patterns

### Strategy (B)

Following the ***Open/Closed principle*** of SOLID, the Strategy design pattern is applied. Instead of having concrete implementations of metric calculations (calculateLOC(), calculateNOM(), calculateNOC()) within the SourceCodeAnalyzer class, an interface (MetricCalculator) was added instead and has multiple implementations for each metric. This allows new metrics to be added by implementing the MetricCalculator interface without modifying the existing class.
<br>The same is applied for the other 2 classes (MetricExporter.java, SourceFileReader.java).<br><br>
<b>Classes</b>


`SourceCodeAnalyzer.java` is connected with the interface `MetricCalculator.java`.<br>
This interface is currently implemented by `calculateLOC.java`, `calculateNOM.java` and `calculateNOC.java`.
<br><br>
`SourceFileReader.java` communicates with `SourceCodeAnalyzer.java` and is also connected with the interface `FileReader.java`.
<br>This interface is currently implemented by `ReadToList.java` and `ReadToString.java`.
<br><br>
`MetricsExporter.java` is connected with the interface `MetricExporter.java`.
<br>This interface is currently implemented by `ExportCsv.java` and `ExportJson.java`.
<br>
<br>
***Benefits***:
<ul>
    <li>More flexible</li>
    <li>More scaleable</li>
    <li>Easier to test</li>
</ul>

***Drawbacks***:
<ul>
    <li>Higher Complexity</li>

</ul>

### Facade (S)


The Facade pattern provides a unified interface that encapsulates complex subsystems or libraries, <b>simplifying their usage for clients</b>. It acts as a single entry point and shields clients from the underlying implementation details. <br>
Here a new class CodeAnalyzerFacade is created, which will serve as the facade for the code analysis functionality. The CodeAnalyzerFacade class will have a simplified interface that accepts the required information from the DemoClient. It will internally handle the complexity of interacting with the existing classes in the codeanalyzer package.
<br><br>
<b>Classes</b>
<br>
<br>`DemoClient.java` communicates only with `CodeAnalyzerFacade.java`.<br>
`CodeAnalyzerFacade.java` is connected with `SourceCodeAnalyzer.java` and `MetricsExporter.java` and handles all the underlying functionality.
<br>
<br>
***Benefits***:
<ul>
    <li>Simplifies usage</li>
    <li>Hides implementation details</li>
    <li>Enhances maintainability</li>
    <li>Improves Readability</li>
</ul>

***Drawbacks***:
<ul>
    <li>Limited Flexibility</li>

</ul>

## License

[MIT](../LICENSE.md)
