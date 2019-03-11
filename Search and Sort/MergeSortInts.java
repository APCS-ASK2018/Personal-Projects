
public class MergeSortInts
{
    private MergeSortInts() { /* I don't want this instantiable! :p */ }
    private static int[] arr;
    private static int partitionSize;
    private static boolean showSteps;
    
    public static void showSteps(boolean tf) {showSteps = tf;}
    private static void printStep(int start, int end) {
        if(showSteps) {
            System.out.print("  Partition [" + start + "," + end + "] (" + partitionSize + ")\t\t\t");
            Util.printArr(arr);
        }
    }
    
    public static void sortWithInsert(int[] array) {
        arr = array;
        partitionSize = 1;
        while(partitionSize < arr.length) {
            // While partitions have not been fully "merged"
            for(int i = 0; i < arr.length; i+= 2 * partitionSize) {
                // Merge 2 partitions at a time
                int endPart = i + 2 * partitionSize - 1;
                if(endPart >= arr.length) endPart = arr.length - 1;
                
                mergeInsert(i, endPart);
            }
            
            partitionSize *= 2;
        }
        arr = null;
    }
    
    public static void sortWithArr(int[] array) {
        arr = array;
        partitionSize = 1;
        while(partitionSize < arr.length) {
            // While partitions have not been fully "merged"
            for(int i = 0; i < arr.length; i+= 2 * partitionSize) {
                // Merge 2 partitions at a time
                int endPart = i + 2 * partitionSize - 1;
                if(endPart >= arr.length) endPart = arr.length - 1;
                
                mergeTempArr(i, endPart);
            }
            
            partitionSize *= 2;
        }
        arr = null;
    }
    
    /*Hmmm this shifting might raise the time complexity...*/
    private static void mergeInsert(int low, int high) {
        for(int i = low + partitionSize; i <= high; i++) {
            // Insertion sort for second half into first half
            int n = arr[i];
            int j = i - 1;
            while(j >= low && n < arr[j])
                arr[j + 1] = arr[j--];
            arr[j + 1] = n;
        }
        
        if(low + partitionSize <= high) printStep(low, high);
    }
    
    /*Typical implementation with temporary array*/
    private static void mergeTempArr(int low, int high) {
        // Leftover partition can be skipped
        int secondPart = low + partitionSize;
        if(secondPart <= high) {
            int[] temp = new int[high - low + 1];
            
            int first = low, second = secondPart, i = 0;
            while(first < secondPart && second <= high)
                if(arr[first] <= arr[second]) temp[i++] = arr[first++];
                else temp[i++] = arr[second++];
            while(first < secondPart) temp[i++] = arr[first++];
            while(second <= high) temp[i++] = arr[second++];
            
            for(int j = 0; j < temp.length; j++) arr[low + j] = temp[j];
            // The above for-loop can be replaced by this 1 line
            // System.arraycopy(temp, 0, arr, low, temp.length);
            
            printStep(low, high);
        }
    }
}
