/*
 * filename: SortMain.java
 * author: roland carter
 * date: 2019-07-07
 * purpose: main method to print bubble sort outputs
*/

package project_1;

import java.util.stream.IntStream;

// bring SortMain
public class SortMain {

    public static void main(String[] args) throws UnsortedException {
        // jvm warm up size
        final int WARMUP_SIZE = 100;
        final int NUM_ARRAYS = 10;
        
        // create array of consectutive integers of size NUM_ARRAYS
        int[] numRows = new int[]{4,8,16,32,64,128,256,512,1024,2048};

        // run java runtime warm up using BenchmarkSorts.runSorts()
        System.out.println(String.format("%13s %13s",
                "JVM Warmup:",
                "\t  Runtime (ns):"));
        for (int i = 0; i < WARMUP_SIZE; i++) {
            // get start time for run
            long start = System.nanoTime();
            
            // initiate BenchmarkSorts instance
            BenchmarkSorts jvmWarmup = new BenchmarkSorts(numRows);
            jvmWarmup.runSorts();
            
            // get end time
            long end = System.nanoTime();
            
            // calculate runtime
            long duration = (end - start);
            
            // print out results
        System.out.println(String.format("%13s %13s",
                i,
                duration));
        }
        
        // diplay algo report
        BenchmarkSorts b = new BenchmarkSorts(numRows);
        b.runSorts();
        b.displayReport();
    }
} // end SortMain
