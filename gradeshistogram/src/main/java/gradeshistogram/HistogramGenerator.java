/**

The HistogramGenerator class generates a histogram from a list of grades provided in a file.
It uses the JFreeChart library to create the chart and displays it in a window.

*/
package gradeshistogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramBin;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYBarDataset;

public class HistogramGenerator {
	
	/**
	 * The main method reads the grades file and generates the histogram.
	 * @param args The command line arguments. The path to the grades file should be provided as the first argument.
	 * @throws IOException If there is an error reading the file.
	 */
    public static void main(String[] args) throws IOException {
    	// Check if the grades file path is provided as a command line argument
        if (args.length == 0) {
            System.out.println("Please provide the path to the grades file as a command line argument.");
            System.exit(0);
        }

        String gradesFilePath = args[0];
        
        // Read the grades from the file
        List<Integer> grades = readGradesFromFile(gradesFilePath);
        
        // Check if there are any valid grades in the file
        if (grades.isEmpty()) {
            System.out.println("No valid grades found in the file.");
            System.exit(0);
        }

        // Sort the grades in ascending order
        Collections.sort(grades);

        // Create a histogram dataset from the grades
        HistogramDataset dataset = createHistogramDataset(grades);

        // Create a histogram chart from the dataset
        JFreeChart chart = createHistogramChart(dataset);

        // Create a chart frame and display the chart in a window
        ChartFrame frame = new ChartFrame("Grades Histogram", chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method reads the grades from the file and returns them as a list of integers.
     * @param filePath The path to the grades file.
     * @return The list of grades as integers.
     * @throws IOException If there is an error reading the file.
     */
    private static List<Integer> readGradesFromFile(String filePath) throws IOException {
        List<Integer> grades = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = null;
        while ((line = reader.readLine()) != null) {
            try {
                int grade = Integer.parseInt(line.trim());
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
              // Ignore lines that cannot be parsed as integers
            }
        }
        reader.close();
        return grades;
    }

    private static HistogramDataset createHistogramDataset(List<Integer> grades) {
        /**
         * Create a new HistogramDataset object and add the grades as a series to it.
         * Each grade will be added to a bin based on its value, with 10 bins in total.
         * 
         * @param grades The list of grades to create a histogram dataset for
         * @return The histogram dataset containing the grades as a series
         */
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Grades Histogram", grades.stream().mapToDouble(i -> i).toArray(), 10);
        return dataset;
    }

    private static JFreeChart createHistogramChart(HistogramDataset dataset) {
        /**
         * Create a new histogram chart based on the given dataset, with custom labels and axis settings.
         * 
         * @param dataset The histogram dataset to create a chart from
         * @return The created histogram chart
         */
        JFreeChart chart = ChartFactory.createHistogram("Grades Histogram", "Grade", "Frequency", dataset,
                PlotOrientation.VERTICAL, false, false, false);

        // Get the plot and domain axis from the chart and set custom settings
        XYPlot plot = chart.getXYPlot();
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setRange(0, 100);
        domainAxis.setTickUnit(new NumberTickUnit(10));
        domainAxis.setVerticalTickLabels(true);

        return chart;
    }
}