
/**
 * Write a description of class BinarySearch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SearchInts
{
    private SearchInts() { /* I don't want this instantiable! :p */ }

    public static int binary(int[] arr, int val) {
        int i = binaryNearRanged(arr, val, 0, arr.length - 1);
        
        return arr[i] == val ? i : -1;
    }
    
    public static int binaryNear(int[] arr, int val) {return binaryNearRanged(arr, val, 0, arr.length - 1);}
    
    public static int binaryNearRanged(int[] arr, int val, int from, int to) {
        int low = from, high = to;
        while(high >= low) {
            int i = (high + low)/2;
            if(arr[i] == val) return i;
            if(arr[low] == val) return low;
            if(arr[high] == val) return high;
            
            if(arr[i] > val)
                high = i - 1;
            else
                low = i + 1;
        }
        return low;
    }
    
}
