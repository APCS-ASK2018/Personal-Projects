
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
        for(int low = 0, high = arr.length - 1, mid = (low + high)/2; high >= low; low++, high--) {
            if(arr[low] == val) return low;
            if(arr[high] == val) return high;
            if(arr[mid] == val) return mid;
            
            if(arr[mid] > val) high = mid;
            else low = mid;
        }
        
        return -1;
    }

    public static int linear(int[] arr, int val) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == val) return i;
        
        return -1;
    }
}
