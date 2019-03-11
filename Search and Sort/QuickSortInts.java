
public final class QuickSortInts
{
    private QuickSortInts() { /* I don't want this instantiable! :p */ }
    private static int[] arr;
    private static boolean showSteps;
    
    public static void showSteps(boolean tf) {showSteps = tf;}
    private static void printStep(int start, int end, int i1, int i2) {
        if(showSteps) {
            System.out.print("  Partition [" + start + "," + end + "]\tSwapped " + i1 + "<->" + i2 + "\t");
            Util.printArr(arr);
        }
    }
    
    public static void sort(int[] array) {
        arr = array;
        sort(0, arr.length - 1);
        arr = null;
    }
    
    private static void swap(int index1, int index2) {
        if(index1 != index2) {
            int temp = arr[index2];
            arr[index2] = arr[index1];
            arr[index1] = temp;
        }
    }
    
    private static void sort(int low, int high) {
        // Just in case wrong param order
        if(high < low) {
            throw new
                RuntimeException("QuickSort called with " + low + ", " + high);
        }
        
        // Pick first element of the partition as pivot
        int pivot = arr[low];
        
        int lowPoint = low;
        int highPoint = high;
        while(highPoint > lowPoint) {
            // Move high pointer down before moving low pointer
            // Since pivot has left bias, pointer should also have left bias too
            // Skip equal values too to avoid redundant swap
            if(arr[highPoint] >= pivot) {
                highPoint--;
                continue;
            }
            if(arr[lowPoint] <= pivot) {
                lowPoint++;
                continue;
            }
            
            // Pointer found target needing to be swapped
            swap(lowPoint, highPoint);
            printStep(low, high, lowPoint, highPoint);
        }
        
        swap(low, lowPoint);
        printStep(low, high, low, lowPoint);
        
        // Left and right partitions are sorted relative to pivot
        // highPoint == lowPoint == pivotPos (low)
        // Only attempt to sort partitions that have 2 or more elements
        if(lowPoint - 1 > low) sort(low, lowPoint - 1);
        if(lowPoint + 1 < high) sort(lowPoint + 1, high);
    }
}
