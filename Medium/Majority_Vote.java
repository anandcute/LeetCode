//You are given an array of integer nums[] where each number represents a vote to a candidate. 
// Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return -1. 

// Note: The answer should be returned in an increasing format.

// Examples:

// Input: nums = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
// Output: [5, 6]
// Explanation: 5 and 6 occur more n/3 times.
// Input: nums = [1, 2, 3, 4, 5]
// Output: [-1]
// Explanation: no candidate occur more than n/3 times.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Majority_Vote {

    // Finding the two most frequent numbers using Boyer-Moore algorithm
    public List<Integer> majorityElement(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) return new ArrayList<>();

        // Step 1: Identify the two potential majority candidates
        int candidate1 = -1, candidate2 = -1, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Step 3: Return result or [-1] if no majority
        return result.isEmpty() ? List.of(-1) : result;
    }

    // Another method

    public List<Integer> majorityVote(List<Integer> nums){
        int n = nums.size();

        List<Integer> list = new ArrayList<>();
        HashMap<Integer , Integer> map = new HashMap<>();  // remove duplicate

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1); // value = duplicate la count panidum
        }
        for(int key : map.keySet()){
            // System.out.println(key);
            // System.out.println(" val " + map.get(key));
            if(map.get(key) > n / 3)    // get(5) = 4    // key yoda value print agum n / 3 ya vida greateer ya irukanum
            {                           //get(6) = 5
                list.add(key);
            }
        }
        if(list.size() == 0)
            list.add(-1);
        // Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        Majority_Vote obj = new Majority_Vote();
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1,1,1,1,4,5,2,2,2,2));
        System.out.println(obj.majorityVote(nums));
        // System.out.println(obj.majorityElement(nums));

    }
    
}