/*
 * filename: BenchmarkSorts.java
 * author: roland carter
 * date: 2019-07-07
 * purpose: creates stats for each algo run
*/

package project_1;


import java.util.HashMap;
import java.util.Random;


public class BenchmarkSorts {
    // create new Bubble sort instance
    private final BubbleSort bubbleSort = new BubbleSort();
    
    // create random instance to generate random lists of numbers
    private final Random rand = new Random();

    // data size sizes the size of the data and NUMBER_OF_DATA_SETS is
    // specified in the project prompt
    private final int[] dataSize;
    private final int NUMBER_OF_DATA_SETS = 50;
    
    // max for random ints
    private final int MAX_INT = 100000;
    
    // TODO: change arrays to iterative/recursive maps for readability
    // create arrays of size NUMBER_OF_DATA_SETS
    private final double[] iterativeCountData = new double[NUMBER_OF_DATA_SETS];
    private final double[] recursiveCountData = new double[NUMBER_OF_DATA_SETS];
    private final double[] iterativeTimeData = new double[NUMBER_OF_DATA_SETS];
    private final double[] recursiveTimeData = new double[NUMBER_OF_DATA_SETS];

    // arrays of iterative run stats
    private final double[] averageIterativeCount;
    private final double[] averageIterativeTime;
    private final double[] coefficientIterativeCount;
    private final double[] coefficientIterativeTime;
    
    // array of recursive
    private final double[] averageRecursiveCount;
    private final double[] coefficientRecursiveCount;
    private final double[] averageRecursiveTime;
    private final double[] coefficientRecursiveTime;

    // constructor
    BenchmarkSorts(int[] sizes) {
        dataSize = sizes;
        averageIterativeCount = new double[sizes.length];
        averageRecursiveCount = new double[sizes.length];
        coefficientIterativeCount = new double[sizes.length];
        coefficientRecursiveCount = new double[sizes.length];
        averageIterativeTime = new double[sizes.length];
        averageRecursiveTime = new double[sizes.length];
        coefficientIterativeTime = new double[sizes.length];
        coefficientRecursiveTime = new double[sizes.length];
    }

    // runSorts creates data for sorts and runs sorts as a monte carlo
    void runSorts() throws UnsortedException {
        for (int i = 0; i < dataSize.length; i++) {
            // grab data for runs
            int[] iterativeData = new int[dataSize[i]];
            int[] recursiveData = new int[dataSize[i]];
            
            // iterat eto create data sets
            for (int n = 0; n < NUMBER_OF_DATA_SETS; n++) {
                
                for (int j = 0; j < dataSize[i]; j++) {
                    int r = rand.nextInt(MAX_INT) + 1;
                    
                    // add random int to arrays
                    iterativeData[j] = r;
                    recursiveData[j] = r;
                }
                
                // perform sorts with data and add time and count outputs to array
                bubbleSort.recursiveSort(recursiveData, recursiveData.length);
                recursiveCountData[n] = bubbleSort.getCount();
                recursiveTimeData[n] = bubbleSort.getTime();

                bubbleSort.iterativeSort(iterativeData);
                iterativeCountData[n] = bubbleSort.getCount();
                iterativeTimeData[n] = bubbleSort.getTime();
            }
            
            // calculate stats from arrays
            averageIterativeCount[i] = getAvg(iterativeCountData);
            coefficientIterativeCount[i] = getCoefficientOfVariance(iterativeCountData);
            averageIterativeTime[i] = getAvg(iterativeTimeData);
            coefficientIterativeTime[i] = getCoefficientOfVariance(iterativeTimeData);

            averageRecursiveCount[i] = getAvg(recursiveCountData);
            coefficientRecursiveCount[i] = getCoefficientOfVariance(recursiveCountData);
            averageRecursiveTime[i] = getAvg(recursiveTimeData);
            coefficientRecursiveTime[i] = getCoefficientOfVariance(recursiveTimeData);
        }
    }

    // getAvg is a helper function to calculate averages (arithmatic mean)
    private double getAvg(double[] data) {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / data.length;
    }


    // StandardDeviation gets the standard dev from the stats from each sort run
    private double getStandardDeviation(double[] data) {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += (data[i] - getAvg(data)) * (data[i] - getAvg(data));
        }
        return Math.sqrt(sum / (data.length - 1));
    }


    // CoefficientOfVariance gets the coefficients of variance for each sort
    private double getCoefficientOfVariance(double[] data) {
        return ((getStandardDeviation(data)) / getAvg(data)) * 100;
    }

    // displayReport creates the format for the report to be displayed
    void displayReport() {
        System.out.println(String.format("%213s",
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
        );
        System.out.println(String.format("%13s %50s %75s",
                "\t  |",
                "Iterative",
                "\t  Recursive"));
        System.out.println(String.format("%13s %200s",
                "\t  |",
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
        );
        System.out.println(String.format("%13s %25s %25s %25s %25s %25s %25s %25s %25s",
                "\tData Size |",
                "Average Critical",
                "Coefficient of",
                "Average",
                "Coefficient of",
                "Average Critical",
                "Coefficient of",
                "Average",
                "Coefficient of"));
        System.out.println(String.format("%13s %25s %25s %25s %25s %25s %25s %25s %25s",
                "\t  |",
                "Operation Count",
                "Variance of Count",
                "Execution Time",
                "Variance of Time",
                "Operation Count",
                "Variance of Count",
                "Execution Time",
                "Variance of Time")
        );
        System.out.println(String.format("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
        );

        for (int i = 0; i < dataSize.length; i++) {
            System.out.format("%14s %25s %25s %25s %25s %25s %25s %25s %26s",
                    dataSize[i],
                    averageIterativeCount[i],
                    coefficientIterativeCount[i],
                    averageIterativeTime[i],
                    coefficientIterativeTime[i],
                    averageRecursiveCount[i],
                    coefficientRecursiveCount[i],
                    averageRecursiveTime[i],
                    coefficientRecursiveTime[i]);
            System.out.println();
        }
    }
}