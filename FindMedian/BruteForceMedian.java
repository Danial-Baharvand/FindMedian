package FindMedian;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BruteForceMedian {

        private static int BruteForceMedian(int[] arr){//Implementation of the algorithm
            int k =(int)  Math.ceil(arr.length/2d);//Find middle position
            for (int i = 0; i <= arr.length-1; i++){//Loop through all elements
                int numSmaller = 0;//Stores number of smaller elements
                int numEqual = 0;//Stores number of equal elements
                for (int j = 0; j <= arr.length-1; j++){//Loop through all elements
                    if(arr[j] < arr[i]) {
                        numSmaller = numSmaller + 1;
                    } else if (arr[j] == arr[i]) {
                        numEqual = numEqual + 1;
                    }
                }
                if (numSmaller < k && k <= (numSmaller + numEqual)) {
                    return arr[i];//Returns median
                }
            }
            return -1;//To avoid java:missing return statement
        }

        private static int correctMedian(int[] numArray){
            // Calculation the expected median value
            int[] localArray = Arrays.copyOf(numArray, numArray.length); // copping the array so we don't change the OG
            Arrays.sort(localArray); // sort the array
            int median;
            if (localArray.length % 2 == 0)//If length is even
                median = localArray[localArray.length/2-1];
            else
                median = localArray[localArray.length/2];
            return median;//Return expected median
        }

        public static void main(String[] args) throws IOException {
            int[] myArray = Data.makeData();//Populate array
            //Console output
            System.out.println("Array: " + Arrays.toString(myArray));
            System.out.println("Median: " + BruteForceMedian(myArray));
            System.out.println("Proven correct Median: " + correctMedian(myArray));
            System.out.println("passed: " + (correctMedian(myArray)==correctMedian(myArray)));
            System.out.println("data rule: " + Data.dataRules);
            //Write to file
            BufferedWriter writer = new BufferedWriter(new FileWriter("functionResults.txt", true));
            writer.write(Arrays.toString(myArray));
            writer.write("\t");
            writer.write(Integer.toString(BruteForceMedian(myArray)));
            writer.write("\t");
            writer.write(Integer.toString(correctMedian(myArray)));
            writer.write("\t");
            writer.write(Boolean.toString(BruteForceMedian(myArray)==correctMedian(myArray)));
            writer.write("\t");
            writer.write(Integer.toString(Data.dataRules));
            writer.newLine();
            writer.close();


        }




}
