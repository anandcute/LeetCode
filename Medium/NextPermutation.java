

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the largest index k such that arr[k] < arr[k + 1]
        int k = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                k = i;
                break;
            }
        }
        
        // If no such index k exists, the array is in descending order
        if (k == -1) {
            // Reverse the array to get the lowest permutation
            reverse(arr, 0, n - 1);
            return;
        }
        
        // Step 2: Find the largest index l greater than k such that arr[k] < arr[l]
        int l = -1;
        for (int i = n - 1; i > k; i--) {
            if (arr[k] < arr[i]) {
                l = i;
                break;
            }
        }
        
        // Step 3: Swap the elements at indices k and l
        swap(arr, k, l);
        
        // Step 4: Reverse the sequence from arr[k + 1] to the end of the array
        reverse(arr, k + 1, n - 1);
    }
    
    // Helper method to swap elements at indices i and j
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Helper method to reverse the array from start to end
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 7, 5, 0};
        nextPermutation(arr1);
        System.out.println(Arrays.toString(arr1)); // Output: [2, 4, 5, 0, 1, 7]

        int[] arr2 = {3, 2, 1};
        nextPermutation(arr2);
        System.out.println(Arrays.toString(arr2)); // Output: [1, 2, 3]

        int[] arr3 = {3, 4, 2, 5, 1};
        nextPermutation(arr3);
        System.out.println(Arrays.toString(arr3)); // Output: [3, 4, 5, 1, 2]
    }
}