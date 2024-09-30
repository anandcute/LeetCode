// Given an unsorted array arr of size n that contains only non negative integers, 
// find a sub-array (continuous elements) that has sum equal to s.
//  You mainly need to return the left and right indexes(1-based indexing) of that subarray.
// Input: arr[] = [1,2,3,7,5], n = 5, s = 12
// Output: 2 4
// Explanation: The sum of elements from 2nd to 4th position is 12.

import java.util.ArrayList;

public class IndexesofSubarraySum {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0 , left = 0 ;
        for(int right = 0 ; right < n ; right++){
            sum += arr[right] ;
            while(sum > s && left <= right){
                sum -= arr[left++] ;
            }
            if(sum == s){
                list.add(left + 1);
                list.add(right + 1);
                return list;
            }
        }
        list.add(-1);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int n = arr.length;
        int s = 12;
        
        System.out.println(subarraySum(arr, n, s));
    }

}
