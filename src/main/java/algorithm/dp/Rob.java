package algorithm.dp;

/**
 * @Description: 打家劫舍，不能相邻偷，求最大值
 * @Author: bsy
 * @Date: 2023/2/21 19:01
 */
public class Rob {
    /**
     * 打家劫舍1， 不能相邻偷，求最大值， 街道是直的
     * @param nums
     * @return
     */
    public int rob (int[] nums) {
        // write code here
        int length = nums.length;
        if(length<=0){return 0;}
        if(length==1){return nums[0];}
        int[] dp = new int[length + 1];
        dp[1] = nums[0];

        for(int i=2; i<=length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }

        return dp[length];
    }

    /**
     * 打家劫舍1， 不能相邻偷，求最大值，街道是园的；分两种情况，构造两个dp，然后取最大值
     * @param nums
     * @return
     */
    public int rob2 (int[] nums) {
        // write code here
        int length = nums.length;
        if(length<=0){return 0;}
        if(length==1){return nums[0];}
        int[] dp = new int[length + 1];
        dp[1] = nums[0];

        for(int i=2; i<=length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        int res1 = dp[length-1];
        dp[1] = 0;
        for(int j=2; j<=length; j++){
            dp[j] = Math.max(dp[j-2] + nums[j-1], dp[j-1]);
        }

        return Math.max(res1, dp[length]);
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] arr = new int[]{1,2,3,4};
        int rob1 = rob.rob(arr);
        System.out.println(rob1);
    }

}
