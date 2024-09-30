public class CountSubArray {
    public static int countSubArray(int arr[] , int n , int k){
        int count = 0;
        int length = 0;
        int ans = 0;

        for(int i =0 ; i < n ; i++){
            if(arr[i] > k){
                count = i + 1;
                length++;
            }
            if (length > 0) {
                ans += count;
            }
        }
        return ans;
    }
    //Another logic use total = (n*(n+1)) / 2
    public static long countSubArray1(int arr[] , int n , int k){
        int count = 0;
        int length = 0;
        long totalSubArray = (n*(n+1)) / 2 ;

        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= k){
                length++;
            }
            else{
                count += (length*(length+1)) / 2 ;
                length = 0;
            }
            
        }
        count += (length*(length+1)) / 2 ;
        return totalSubArray - count;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3 , 4};
        int n = arr.length;
        int k = 2;
        System.out.println(countSubArray(arr, n, k));
        System.out.println(countSubArray1(arr, n, k));

    }
}
