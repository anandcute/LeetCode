import java.util.Arrays;

public class FrequencyCounter {
    public static void findFrequencies(int[] arr, int n , int p) {
       p++;
       for(int i = 0 ; i< n ; i++){
        int index = (arr[i] % p ) - 1 ;
        if(index >= 0 && index < n)
            arr[index] += p;        //increasing frequency
       }
       for(int i = 0 ; i < n ; i++){
           arr[i] /= p ;
       }
    }

    public static void main(String[] args) {
        // Example usage
        int n = 5; int p = 5;
        int[] arr = {2, 3, 2, 3, 5};
        
        findFrequencies(arr, n , p);
        System.out.println(Arrays.toString(arr)); // Output: [0, 2, 2, 0, 1]
    }
}
