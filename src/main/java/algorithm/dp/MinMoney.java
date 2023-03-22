package algorithm.dp;

import java.util.Arrays;

/**
 * @Description: 兑换零钱, 数字大于0
 * @Author: bsy
 * @Date: 2023/2/21 18:23
 */
public class MinMoney {
    public int minMoney (int[] arr, int aim) {
        // write code here
        if(arr.length <= 0){return -1;}
        int[] dp = new int[aim+1];

        for(int i=1; i<=aim; i++){
            int tmp = Integer.MAX_VALUE;
            for(int coin:arr){
                if(i-coin >= 0 && dp[i-coin] >= 0){
                    tmp = Math.min(tmp, dp[i - coin] + 1);
                }
            }
            dp[i] = tmp==Integer.MAX_VALUE?-1:tmp;
        }
        System.out.println(Arrays.toString(dp));
        return dp[aim];
    }

    public static void main(String[] args) {
        MinMoney minMoney = new MinMoney();
        int[] money = new int[]{5,2,3};
        int res = minMoney.minMoney(money, 20);
        System.out.println(res);
    }
}
