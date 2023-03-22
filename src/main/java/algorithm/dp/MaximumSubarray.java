package algorithm.dp;

/**
 * @Description: 最大子数组(连续)
 * @Author: bsy
 * @Date: 2022/12/5 18:21
 */
public class MaximumSubarray {
    int maximumSubarrayV1(int[] nums){
        //定义dp：以nums[i]为结尾的最大子数组和为dp[i],那么对于dp[i+1], 就是max(dp[i], dp[i-1] + nums[i])

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(nums[i],   dp[i-1] + nums[i]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    int maximumSubarrayV2(int[] nums){
        //优化存储
        //定义dp：以nums[i]为结尾的最大子数组和为dp[i],那么对于dp[i+1], 就是max(dp[i], dp[i-1] + nums[i])

        int now, before=nums[0];
        int maxValue = nums[0];
        for(int i=1; i<nums.length; i++){
            now = Math.max(nums[i], before + nums[i]);
            before = now;
            maxValue = Math.max(maxValue, now);
        }
       return maxValue;
    }
}
