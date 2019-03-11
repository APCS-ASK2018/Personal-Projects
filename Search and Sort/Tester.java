import java.util.function.Consumer;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Tester
{
    private static final Scanner kb = new Scanner(System.in);
    
    private Tester() { /* I don't want this instantiable! :p */ }
    
    private static void setDebug(boolean tf) {
        QuickSortInts.showSteps(tf);
        MergeSortInts.showSteps(tf);
    }
    
    private static int[] genUniqueNums(int length) {
        return java.util.stream.IntStream.generate(() -> (int) (Math.random() * 50))
            .distinct()
            .limit(length)
            .toArray();
    }
    
    public static void main() {
        int[] arr = genUniqueNums(13);
        do {
            sortInts(arr.clone(), true);
            System.out.print("Repeat with same array? (\"Yes\")  ");
        } while("Yes".equalsIgnoreCase(kb.nextLine()));
    }
    
    public static void sortInts(int[] arr, boolean debug) {
        // Map of sort method names to their method
        LinkedHashMap<String, Consumer<int[]>> map = new LinkedHashMap<>();
        map.put("QuickSort" , QuickSortInts::sort);
        map.put("MergeSort (insert)" , MergeSortInts::sortWithInsert);
        map.put("MergeSort (arr)", MergeSortInts::sortWithArr);
        
        // Get array of method names (the key)
        Object[] key = map.keySet().toArray();
        
        System.out.println("How would you like to sort your int[] (Type the index number) ?");
        Util.printArr(key);
        
        int userChoice = Integer.parseInt(kb.nextLine(), 10);
        String sortMethod = (String) key[userChoice];
        System.out.println("You selected " + sortMethod);
        
        System.out.print("Your array before sorting\n\t\t\t\t\t");
        Util.printArr(arr);
        
        // Run the sorting algorithm with/without debug mode
        setDebug(debug);
        map.get(sortMethod).accept(arr);
        
        System.out.print("Your array after sorting\t\t");
        Util.printArr(arr);
    }
}
