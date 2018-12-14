import java.util.function.Consumer;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Scanner;

/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    private Tester() { /* I don't want this instantiable! :p */ }
    
    private static void setDebug(boolean tf) {
        QuickSortInts.showSteps(tf);
        MergeSortInts.showSteps(tf);
    }
    
    public static void sortInts(int[] arr, boolean debug) {
        // Map of sort method names to their method
        LinkedHashMap<String, Consumer<int[]>> map = new LinkedHashMap<>();
        map.put("QuickSort" , QuickSortInts::sort);
        map.put("MergeSort" , MergeSortInts::sort);
        
        // Get array of method names (the key)
        Object[] key = map.keySet().toArray();
        
        Scanner kb = new Scanner(System.in);
        
        System.out.println("How would you like to sort your int[] (Type the index number) ?");
        Util.printArr(key);
        int userChoice = kb.nextInt();
        String sortMethod = (String) key[userChoice];
        System.out.println("You selected " + sortMethod);
        
        System.out.println("Your array before sorting");
        Util.printArr(arr);
        
        // Run the sorting algorithm with/without debug mode
        setDebug(debug);
        map.get(sortMethod).accept(arr);
        
        System.out.println("Your array after sorting");
        Util.printArr(arr);
    }
}
