import java.util.*;
public class RotateDeleteArray {


    // Function to perform the required operations and return the first element
    public static int findFirstElement(List<Integer> arr) {
        int sz = arr.size();

        for (int k = 1; k <= sz / 2; k++) {
            // Rotate the array to the right by 1
            Collections.rotate(arr, 1);

            // Calculate the index to delete: (n - k)th index from the beginning
            int n = arr.size();
            int deleteIndex = n - k;

            // Remove the (n - k + 1)th element
            arr.remove(deleteIndex);
        }
        
        // Return the first element after all operations
        return arr.get(0);
    }

    public static void main(String[] args) {
        // Example 1
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("First element after operations: " + findFirstElement(arr1)); // Output: 3

        // Example 2
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("First element after operations: " + findFirstElement(arr2)); // Output: 2
    }
}


