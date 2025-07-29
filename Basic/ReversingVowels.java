// Given a string consisting of lowercase english alphabets, reverse only the vowels present in it and print the resulting string.

// Example 1:

// Input:
// S = "geeksforgeeks"
// Output: geeksforgeeks
// Explanation: The vowels are: e, e, o, e, e
// Reverse of these is also e, e, o, e, e.

// Example 2:

// Input: 
// S = "practice"
// Output: prectica
// Explanation: The vowels are a, i, e
// Reverse of these is e, i, a.




public class ReversingVowels {
   static boolean isVowel(char s) {
        return s == 'u' || s == 'e' || s == 'o' || s == 'a' || s == 'i';
    }
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0 ;
        int j = s.length()-1;
        while (i < j) {
            if (!isVowel(chars[i])) {
                i++;
                } else if (!isVowel(chars[j])) {
                    j--;
                }
                else {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                    }
            
        }
        return new String(chars);
    }

    public static String reverseVowel(String s){
        char[] ch = s.toCharArray();
        int i = 0 ;
        int j = s.length()-1;
        while(i > j){
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                if(ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u'){
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
                else   
                    j--;
            }
            else
                i++;
        }
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        System.out.println(reverseVowel("geeksforgeeks")); // Output: holle
    }
}
