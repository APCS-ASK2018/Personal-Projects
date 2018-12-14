
/**
 * Write a description of class MergeSortInts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MergeSortInts
{
    private MergeSortInts() { /* I don't want this instantiable! :p */ }
    private static int[] arr;
    private static int partitionSize;
    private static boolean showSteps;
    
    public static void showSteps(boolean tf) {showSteps = tf;}
    private static void printStep(int start, int end, int from, int to) {
        if(showSteps) {
            System.out.print("  Partition [" + start + "," + end + "] (" + partitionSize + ")"+ "\tMove " + from + "->" + to + "\t");
            Util.printArr(arr);
        }
    }
    
    public static void sort(int[] array) {
        arr = array;
        partitionSize = 1;
        while(partitionSize < arr.length) {
            // While partitions have not been fully "merged"
            for(int i = 0; i < arr.length; i+= 2 * partitionSize) {
                // Merge 2 partitions at a time
                int endPart = i + 2 * partitionSize - 1;
                if(endPart >= arr.length) endPart = arr.length - 1;
                merge(i, endPart);
            }
            
            partitionSize *= 2;
        }
        arr = null;
    }
    
    private static void merge(int low, int high) {
        int endFirstPart = low + partitionSize - 1;
        for(int i = endFirstPart + 1; i <= high; i++) {
            // Search insertPoint from the sorted interval (low ~ current element)
            int insertPoint = SearchInts.binaryNearRanged(arr, arr[i], low, i - 1);
            if(insertPoint != i) {
                printStep(low, high, i, insertPoint);
                moveData(i,insertPoint);
            }
        }
    }
    
    private static void moveData(int from, int to) {
        assert from >= to;
        
        int temp = arr[from];
        while(from > to) {
            arr[from] = arr[--from];
        }
        arr[to] = temp;
    }
}
