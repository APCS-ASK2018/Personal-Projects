
/**
 * Write a description of class Util here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class Util
{
    private Util() { /* I don't want this instantiable! :p */ }
    
    public static void printArr(Object[] arr) {
        String s = "";
        for(Object obj : arr)
            s += ", " + obj.toString();
        System.out.println("[" + s.substring(2) + "]");
    }

    public static void printArr(int[] arr) {
        String s = "";
        for(int i : arr)
            s += ", " + i;
        System.out.println("[" + s.substring(2) + "]");
    }
    
    public static void printArr(char[] arr) {
        String s = "";
        for(char c : arr)
            s += ", " + c;
        System.out.println("[" + s.substring(2) + "]");
    }
    
    public static void printArr(double[] arr) {
        String s = "";
        for(double d : arr)
            s += ", " + d;
        System.out.println("[" + s.substring(2) + "]");
    }
}
