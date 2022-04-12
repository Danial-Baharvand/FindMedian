package FindMedian;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static java.nio.file.StandardOpenOption.APPEND;

public class BruteForceMedianTimeCount {
    // system time calculation has been inspired by
    // https://stackoverflow.com/questions/7467245/cpu-execution-time-in-java
    // options
    // Change the value of runs to modify the number of times the algorithm will be executed
    static final int runs=1000000;
    // Change the value of wormUpRuns to modify the number of times the algorithm
    // will be executed without being recorded
    static final int wormUpRuns=1000000;
    static long time;
    static long BruteForceMedianTimeCount(int[] arr) {
        long start = 0; // stores the system time after the first (10000) executions
        for(int t=-wormUpRuns;t<runs;t++) {
            // skipping first (10000) runs to include CPU JDE, CPU and cashing optimazations
            if(t == 0) start = System.nanoTime();
            // The algorithm
            int k =(int)  Math.ceil((arr.length)/2d);
            for (int i = 0; i <= arr.length-1; i++){
                int numSmaller = 0;
                int numEqual = 0;
                for (int j = 0; j <= arr.length-1; j++) {
                    if(arr[j] < arr[i]){
                        numSmaller = numSmaller + 1;
                    } else if (arr[j] == arr[i]){
                        numEqual = numEqual + 1;
                    }
                }
                if (numSmaller < k && k <= (numSmaller + numEqual)){
                    //return arr[i];
                    break; // Using a break instead of return so that outer loop continues
                }
            }
        }
         time = System.nanoTime() - start;// recording the passed time
            return time;
    }

        public static void main(String[] args) throws IOException {
            int[] myArray = Data.makeData(); // make test data
            BruteForceMedianTimeCount(myArray);
            //Print to console
            System.out.println("Array: " + Arrays.toString(myArray));
            System.out.printf("Each run of the algorithm took an average of %,d ns%n", time/runs);
            System.out.printf("The total of %d runs took %,d ns%n",runs, time );
            //Print to file
            BufferedWriter writer = new BufferedWriter(new FileWriter("timeResults.txt", true));
            writer.write(Integer.toString(myArray.length));
            writer.write("\t");
            writer.write(Long.toString(time/runs));
            writer.newLine();
            writer.close();

        }




}
