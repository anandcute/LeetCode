

public class PalindromeCheck {
    public boolean isPalindrome(int x) {
        int original = x ;
        int r , rev = 0;
        while(x > 0){
            r = x % 10 ; 
            rev = rev * 10 +  r;
            x /= 10;
        }  
        
       return original == rev; 
    
    }
    
    public static void main(String[] args) {
        PalindromeCheck obj = new PalindromeCheck();
        System.out.println(obj.isPalindrome(12321)); // true
    }
}
