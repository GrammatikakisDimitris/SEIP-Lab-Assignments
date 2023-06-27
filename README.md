# SEIP-2023 Practical Assignments ![Deploy Badge](https://github.com/GrammatikakisDimitris/SEIP-Lab-Assignments/actions/workflows/main.yml/badge.svg)

This project consists of several modules that provide functionality for different tasks related to software engineering. The first of these is the **gradeshistogram** module, which provides functionality for reading a file containing grades and generating a histogram based on the frequencies of these grades. The second is the **unittesting** module, which provides unit testing for normal, border, zero cases, and exceptions for classes that perform math operations. The last module is the [***sourcecodeanalyzer***](/sourcecodeanalyzer/README.md), designed to analyze Java source code using various design patterns. It features a command-line interface for running the application and supports multiple output formats.

## Prerequisites
Before running any of the modules, you need to have Maven and Java and installed on your system.

## Installation

1. Clone the parent project repository from GitHub:

        git clone https://github.com/GrammatikakisDimitris/SEIP-Lab-Assignments.git


2. Navigate to the `parent` directory of the project:

        cd seip2023-practical-assignments


3. Build and install the project:

        mvn clean install

4. Navigate to the `target` directory of the `gradeshistogram` module:
        
        cd gradeshistogram/target

5. Run the jar file with the following command:

        java -jar histogramgenerator-1.0.0-SNAPSHOT-jar-with-dependencies.jar ../src/main/resources/grades.txt



## Usage

### unittesting
If the project is built successfully then all unit tests have passed.

### gradehistogram
After running the jar file, the histogram will be displayed in a separate window. The X-axis represents the grades and the Y-axis represents the frequencies.

### sourcecodeanalyzer
See [sourcecodeanalyzer README.md](/sourcecodeanalyzer/README.md) for details.
## Dependencies

This project depends on the following libraries:

- JFreeChart 1.5.3

- JUnit 4.12

## Contributing

If you would like to contribute to this project, please create a fork and submit a pull request. Please follow the code style and conventions used in this project.

## License

[MIT](/LICENSE.md)

## Contact

If you have any questions or comments about this project, please feel free to contact me at t8200035@aueb.gr.
