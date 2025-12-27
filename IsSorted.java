public class IsSorted {

    // Public function: called by the user
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0);
    }

    // Helper recursive function
    private static boolean isSorted(int[] a, int i) {
        // Base case 1: empty or single element array
        if (a.length <= 1) return true;
        // Base case 2: reached the end and all is good
        if (i == a.length - 1) return true;
        boolean currentSorted = a[i] <= a[i + 1];
        return currentSorted && isSorted(a, i+1); 
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
    }
}
