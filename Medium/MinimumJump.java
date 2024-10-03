public class MinimumJump {
    public int minJump(int arr[]){
        int n = arr.length;
        int jump = 0 ;          //Greedy Approach
        int curEnd = 0 ;
        int farest = 0 ;
        if(n <= 1)
           return 0;
        if(arr[0] == 0)
            return -1;
        for(int i = 0 ; i < n ; i++){
            farest = Math.max(farest, i + arr[i]);

            if(i == curEnd){
                curEnd = farest ;
                jump++;

                if(curEnd >= n - 1){
                    // System.out.println(curEnd);
                    break;
                }
            }
        }
        if(curEnd < n -1)
         return -1;
        return jump;
    }
    public static void main(String[] agrs){
        MinimumJump min = new MinimumJump();
        int arr[] = {1,3,5,8,9,2,6,7,6,8,9};
        System.out.println(min.minJump(arr));
    }
}
