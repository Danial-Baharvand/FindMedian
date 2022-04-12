package FindMedian;

import java.util.Arrays;

public class BruteForceMedianBasicFind {
    //basic operation test variables
    static int t1=0;
    static int t2=0;
    static int t3=0;
    static int t4=0;
    static int t5=0;
    static int t6=0;
    static int t7=0;
    static int t8=0;
    static int i=0; // i is initialised here so we can keep track of it for calculation of expected basic operation

        static int BruteForceMedianBasicFind(int[] arr){
            t1++;// testing occurrence of int k assignment
            int k =(int)  Math.ceil((arr.length)/2d);
            for (i = 0; i <= arr.length-1; i++){
                t2++;// testing occurrence of for loop condition check
                int numSmaller = 0;
                int numEqual = 0;
                t3++;//testing occurrence of integers numSmaller and numEqual assignment
                for (int j = 0; j <= arr.length-1; j++){
                    t4++; // testing occurrence of for loop and if statement condition check
                    if(arr[j] < arr[i]) {
                        t5++;//testing the number of times arr[j] is smaller than arr[i]
                        numSmaller = numSmaller + 1;
                    } else if (arr[j] == arr[i]){
                        t6++; //testing the number of times arr[j] is is equal to arr[i]
                        numEqual = numEqual + 1;
                    }
                }
                t7++;////testing how many times the return condition is checked
                if (numSmaller < k && k <= (numSmaller + numEqual)) {
                    t8++;//testing how many times the result is returned ( would be 1 time obviously)
                    return arr[i];
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            int[] myArray = Data.makeData();// Populate the array
            // Print to console
            System.out.println("array\t" + Arrays.toString(myArray));
            System.out.println("dataRule\t" + Data.dataRules);
            System.out.println("array length\t" + myArray.length);
            System.out.println("Median\t" + BruteForceMedianBasicFind(myArray));
            System.out.println("k assignment\t" + t1);
            System.out.println("first for loop condition\t" + t2);
            System.out.println("numSmaller and numEqual assignment\t" + t3);
            System.out.println("for loop and if statement condition check\t" + t4);
            System.out.println("arr[j] is smaller than arr[i] check\t" + t5);
            System.out.println("arr[j] is is equal to arr[i] check\t" + t6);
            System.out.println("return condition check\t" + t7);
            System.out.println("result is returned\t" + t8);
            System.out.println("The basic operation has been performed\t" + t4 + " times");
            System.out.println("expected basic operation occurrence\t" + myArray.length*(i+1));
        }




}
