

public class MaximumSumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currentsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(currentsum < 0){
                currentsum = nums[i];
            }
            else{
                currentsum += nums[i];
            }
        }
        maxsum = Math.max(maxsum, currentsum);
        return maxsum;
    }
    public static void main(String[] args) {
        int nums[] = {-1,2,-1,3,-1,-4,3,-1,7,-1};
        System.out.println(maxSubArray(nums));
    }
}
