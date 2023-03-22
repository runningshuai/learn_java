package algorithm.dp;

import java.util.Arrays;

/**
 * @Description: 零钱兑换
 * @Author: bsy
 * @Date: 2022/12/5 16:21
 */
public class CoinChange {

    int coinChange(int coins[], int amount){
        // 需要取值amount，所以要+1
        int[] dp = new int[amount + 1];
        //最多amount个，初始化为amount + 1便于取最小值
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        //对于每一种金额
        for(int i=0; i<=amount; i++){
            //遍历所有可用的金币取值，取最小
            for(int coin:coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1+dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ?-1: dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        int res = coinChange.coinChange(coins, amount);
        System.out.println(res);
    }
}
