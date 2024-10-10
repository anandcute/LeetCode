// package LeetCode.Easy;

// Given an array arr[] with repeated elements, the task is to find the maximum distance between two occurrences of an element.

// Note: You may assume that every input array has repetitions.

// Examples:

// Input: arr = [1, 1, 2, 2, 2, 1]
// Output: 5
// Explanation: distance for 1 is: 5-0 = 5, distance for 2 is : 4-2 = 2, So max distance is 5.
// Input: arr = [3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2]
// Output: 10
// Explanation: maximum distance for 2 is 11-1 = 10, maximum distance for 1 is 4-2 = 2 ,maximum distance for 4 is 10-5 = 5, 
// So max distance is 10.


import java.util.HashMap;
import java.util.Map;

public class MaxIndexOfElement {
    public static int maxIndexOfElement(int[] arr){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(arr[i])){
                max = Math.max(max, i - map.get(arr[i]));
            }
            else{
                map.put(arr[i], i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,1};
        System.out.println(maxIndexOfElement(arr)); // 5
    }
}
