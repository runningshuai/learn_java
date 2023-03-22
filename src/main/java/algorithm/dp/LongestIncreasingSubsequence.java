package algorithm.dp;

import java.util.Arrays;

/**
 * @Description: 最长递增子序列（不连续）; 1,4,3,4,2,3
 * @Author: bsy
 * @Date: 2022/12/5 17:11
 */
public class LongestIncreasingSubsequence {
    int lengthOfLIS(int[] nums){
        // 定义dp[i],为以i为结尾的元素nums[i]，其最长子序列的长度
        int[] dp = new int[nums.length];
        //初始化数组
        Arrays.fill(dp, 1);
        //生成dp, 当前dp[i]和小于dp[i]的元素拼接起来，即为当前元素的最长子序列
        for(int i=0; i<nums.length; i++){
            //小于当前值num  s[i]得，皆是其取值范围
            for(int j=0; j<i; j++){
                //比当前元素小
                if(dp[j] < dp[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //求取最大值,即为最长子序列
        int res = 0;
        for (int value : dp) {
            res = Math.max(res, value);
        }

        return res;
    }
}
