// Reverse a string with spaces intact
// Difficulty: BasicAccuracy: 45.83%Submissions: 10K+Points: 1
// Given a string, your task is to reverse the string keeping the spaces intact to their positions.

// Example 1:

// Input:
// S = "Help others"
// Output: sreh topleH
// Explanation: The space is intact at index 4
// while all other characters are reversed.
// Example 2:

// Input: 
// S = "geeksforgeeks"
// Output: skeegrofskeeg
// Explanation: No space present, hence the
// entire string is reversed.

import java.util.Arrays;

public class ReverseString {
    
       static String reverse(String str){
            return new StringBuilder(str).reverse().toString();
        }
        
        static String reverseWithSpacesIntact(String S)
        {
            
            String[] strArr=S.split(" ");
            // System.out.println(Arrays.toString(strArr));
            StringBuilder sb = new StringBuilder();
            for(int i=strArr.length-1;i>=0;i--){
                sb.append(reverse(strArr[i]));
            }
    
            for(int i=0;i<S.length();i++){
                char ch = S.charAt(i);
                if(ch==' '){
                    sb = sb.insert(i,' ');
                }
            }
            return sb.toString();

    }

    static String reversed(String str){
        char[] ch = str.toCharArray();
        int left = 0, right = ch.length - 1;
        while (left <= right) {
            if(ch[left] == ' '){
                left++;
                continue;
            }
            if(ch[right] == ' '){
                right--;
                continue;
            }
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
        }
        return String.valueOf(ch);
    } 
    public static void main(String[] args) {
        String s = "Help others";
        System.out.println(reverseWithSpacesIntact(s));
        // System.out.println(reversed(s));

    }
}
