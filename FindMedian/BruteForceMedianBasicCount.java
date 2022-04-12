package FindMedian;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BruteForceMedianBasicCount {
    static int t1=0;    //store the number of basic operations performed
    static int i=0; // i is initialised here so we can keep track of it for calculation of expected basic operation

        static int BruteForceMedianBasicCount(int[] arr){
            int k =(int)  Math.ceil((arr.length)/2d);
            for (i = 0; i <= arr.length-1; i++){
                int numSmaller = 0;
                int numEqual = 0;
                for (int j = 0; j <= arr.length-1; j++){
                    t1++;// Incremented every time basic operation is performed
                    if(arr[j] < arr[i]) {
                        numSmaller = numSmaller + 1;
                    } else if (arr[j] == arr[i]) {
                        numEqual = numEqual + 1;
                    }
                }
                if (numSmaller < k && k <= (numSmaller + numEqual)) {
                    return arr[i];
                }
            }
            return -1;
        }

        public static void main(String[] args) throws IOException {
            int[] myArray = Data.makeData(); // Populate the array
            /*//Uncomment to print to console
            System.out.println("Array: " + Arrays.toString(myArray));
            System.out.println("Median: " + BruteForceMedianBasicCount(myArray));
            System.out.println("The basic operation has been performed " + t1 + " times");
            System.out.println("expected basic operation occurrence: " + myArray.length*(i+1));*/
            // Print to file
                t1 = 0; // reset t1 so it's fresh after console run
                myArray = Data.makeData();
                BufferedWriter writer = new BufferedWriter(new FileWriter("basicCountResults.txt", true));
                writer.write(Arrays.toString(myArray));
                writer.write("\t");
                writer.write(Integer.toString(BruteForceMedianBasicCount(myArray)));
                writer.write("\t");
                writer.write(Integer.toString(i));
                writer.write("\t");
                writer.write(Integer.toString(myArray.length));
                writer.write("\t");
                writer.write(Integer.toString(myArray.length * (i + 1)));
                writer.write("\t");
                writer.write(Integer.toString(t1));
                writer.write("\t");
                writer.write(Boolean.toString(t1 == myArray.length * (i + 1)));
                writer.newLine();
                writer.close();
        }




}
