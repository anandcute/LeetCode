//Given a sorted array arr[] of positive integers, 
// find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.

// Examples:

// Input: arr[] = [1, 2, 3]
// Output: 7
// Explanation: 7 is the smallest positive number for which no subset is there with sum 7.
// Input: arr[] = [3, 6, 9, 10, 20, 28]
// Output: 1
// Explanation: 1 is the smallest positive number for which no subset is there with sum 1.

public class Not_A_Subsetsum {
    public static int subset(int arr[]){
        int n = arr.length;
        int res = 1; // initialzie the smaller size

        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= res){
                res += arr[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(subset(arr));
    }
}
