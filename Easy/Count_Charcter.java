//Given a string S. Count the characters that have ‘N’ number of occurrences. If a character appears consecutively it is counted as 1 occurrence.

// Example 1:

// Input:
// S = "abc", N = 1
// Output: 3
// Explanation: 'a', 'b' and 'c' all have 
// 1 occurrence.

// â€‹Example 2:

// Input: 
// S = "geeksforgeeks", N = 2
// Output: 4
// Explanation: 'g', 'e', 'k' and 's' have
// 2 occurrences.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function getCount() which takes the string S and an integer N as inputs and returns the count of the characters that have exactly N occurrences in the string. Note that the consecutive occurrences of a character have to be counted as 1.


// Expected Time Complexity: O(|S|).
// Expected Auxiliary Space: O(1).




import java.util.HashMap;

public class Count_Charcter {
    public static int getCount(String s , int n){
        HashMap<Character,Integer> map = new HashMap<>();

        char pre = s.charAt(0);
        map.put(pre , 1);
        for(int i= 1 ; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur != pre){
                map.put(cur , map.getOrDefault(cur , 0) + 1);
            }
            
             pre = cur ;
            
        }
        System.out.println(map);
        int count = 0;
        for (Character ch:map.keySet()) {
            if(map.get(ch)==n){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
         System.out.println(getCount("gekesfoergeks", 2));
    }
}
