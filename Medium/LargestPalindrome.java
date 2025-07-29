
// Given a string str, find the longest palindromic substring in str. 
// Substring of string str: str[ i . . . . j ] where 0 ≤ i ≤ j < len(str).
//  Return the longest palindromic substring of str.

// Palindrome string: A string that reads the same backward. More formally, 
// str is a palindrome if reverse(str) = str. In case of conflict, return the substring which occurs first ( with the least starting index).

// Examples :

// Input: str = "aaaabbaa"
// Output: aabbaa
// Explanation: The longest Palindromic substring is "aabbaa".
// Input: str = "abc"
// Output: a
// Explanation: "a", "b" and "c" are the longest palindromes with same length. The result is the one with the least starting index.
// Expected Time Complexity: O(|str|2).
// Expected Auxiliary Space: O(1).

public class LargestPalindrome {
    // 1 way  ( time complexcity high)
    static boolean isPalindrome(String s){
        int start = 0 ; 
        int end = s.length() - 1 ;
        
        while(start < end ){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
            
        }
        return true;
    }
    static String longestPalin(String s){
        // code here
        int n = s.length();
        String str ="";
        int maxlen = 0 ;
        for (int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j <= n ; j++){
                String sub = s.substring(i , j);
                if(isPalindrome(sub) && sub.length() > maxlen){
                    str = sub ;
                    maxlen = sub.length();
                }
            }
        }
        
        return str;
    }
    // 2 ways

    public static String longestPalindrome(String s){
        int n = s.length();
        if(n == 1){
            return s;
        }
        String longest = s.substring(0 , 1);
        for(int i = 0 ; i < n ; i++){
            //odd checking
            String temp = expandAroundCenter(s , i , i);
            if(temp.length() > longest.length()){
                longest = temp ;
            }
            //even checking
            temp = expandAroundCenter(s , i , i+1);
            if(temp.length() > longest.length()){
                longest = temp ;
            }
        }
        return longest ;
    }
    public static String expandAroundCenter(String s , int start , int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1 , end);
    }
    public static void main(String[] args){
        System.out.println(longestPalindrome("aaaabbaa")); //aabbaa
    }
}
// method 

// public String largestPali(String s){
//     int n = s.length();
//     if(n == 1 || n = 0){
//         return s;
//     }
//     int start = 0 ;
//     int end = 0;

//     for(int i = 0 ; i < n ; i++){
//         //odd
//         int oddLength = func(s, i, i);
//         int evenLength = func(s, i, i+1);
//         int largestPali = Math.max(oddLength, evenLength);
//         if(largestPali > (end - start)){
//             start = i - (largestPali - 1) / 2 ;
//             end = i + largestPali / 2 ;
//         }

//     }
//     return s.substring(start,end+1);
// }
// public int func(String s , int start , int end){
//     while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
//         start++;
//         end--;
//     }
//     return end-start-1;
// }