package FindMedian;
public class Data {

    //options
    //dataRule options : 0 = randomised numbers 1 = ascending numbers 2 = descending numbers
    // 3 = median is the last entry 4 = median is the first entry 5 = repeating
    //6 = repeating at begining 7 = repeating at end
    public static int dataRules=1;
    //dataSize options: changes the size of the testData array.
    public static int dataSize=5;

    //code
    private static int[] testData=new int[dataSize];

    //int[] testData,int dataRules
    public static int[] makeData(){
        int[] finalData=new int[testData.length];
        switch (dataRules) {
            case 0:
                for (int i = 0; i < testData.length; i++) {
                    finalData[i] = (int) (Math.random() * 100);
                }
                break;
            case 1:
                for (int i = 0; i < testData.length; i++) {
                    finalData[i] = i;
                }
                break;
            case 2:
                for (int i = 0; i < testData.length; i++) {
                    finalData[i] = (int) (testData.length - i - 1);
                }
                break;
            case 3:

                    finalData = new int[]{9, 28, 61, 66, 40};

                break;
            case 4:

                    finalData = new int[]{40, 9, 28, 61, 66};

                break;
            case 5:

                finalData = new int[]{5, 5, 5, 5, 5};

                break;
            case 6:

                finalData = new int[]{5, 5, 5, 6, 6};

                break;
            case 7:

                finalData = new int[]{5, 5, 6, 6, 6};

                break;
        }
        return finalData;
    }
}
