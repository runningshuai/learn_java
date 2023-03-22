package algorithm.dp;

import java.util.Arrays;

/**
 * @Description: 买卖股票的最好时机
 * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=295&tqId=625&ru=%2Fpractice%2Fa5c127769dd74a63ada7bff37d9c5815&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @Author: bsy
 * @Date: 2023/2/21 21:53
 */
public class BuyStock {
    /**
     * 只能买卖一次
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int length = prices.length;
        if(length < 2){return 0;}
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // dp[i][0]不持股时，手里的价值; dp[i][1]持股时，手里的价值最大(即买股票的最小价值， 会一直记录)
        for(int i=1; i<length; i++){
            // 前一天不持股，或者 前一天持股、当天卖；  完成一次卖的操作
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 前一天持股，或者 前一天不持股，今天买； 完成一次买的操作
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }

        return dp[length-1][0];
    }

    /**
     * 不限制次数的买卖
     * @param prices
     * @return
     */
    public int maxProfit2 (int[] prices) {
        // write code here
        int length = prices.length;
        if(length < 2){return 0;}
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // dp[i][0]不持股时，手里的价值; dp[i][1]持股时，手里的价值最大(即买股票的最小价值， 会一直记录)
        for(int i=1; i<length; i++){
            //不持股：前一天不持股，或者 前一天持股、当天卖；  完成一次卖的操作
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //持股：前一天持股，或者 前一天不持股，今天买； 完成一次买的操作
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[length-1][0];
    }

    /**
     * 最多买两次，最大的收益可能是一次交易或者是二次交易
     * 有五种状态，
     *
     * dp[i][1]表示到第i天为止买过一次股票还没有卖出的最大收益
     * dp[i][2]表示到第i天为止买过一次也卖出过一次股票的最大收益
     * dp[i][3]表示到第i天为止买过两次只卖出过一次股票的最大收益
     * dp[i][4]表示到第i天为止买过两次同时也买出过两次股票的最大收益
     * @param prices
     * @return
     */
    public int maxProfit3 (int[] prices) {
        // write code here
        int length = prices.length;
        if(length < 2){return 0;}
        int[][] dp = new int[length][5];
        //初始化dp为最小,为啥？（第0天的各种状态不存在，数组取不到，需要设置最小值，让max函数取不到）
        Arrays.fill(dp[0], -10000);
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // dp[i][0]不持股时，手里的价值; dp[i][1]持股时，手里的价值最大(即买股票的最小价值， 会一直记录)
        for(int i=1; i<length; i++){
            // dp[i][0]表示到第i天为止没有买过股票的最大收益; 前一天也没买，一直没有买
            dp[i][0] = dp[i-1][0];
            // dp[i][0]表示到第i天为止买过1次股票的最大收益
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            // dp[i][0]表示到第i天为止买过1次也卖过1次股票的最大收益
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            // dp[i][0]表示到第i天为止买过1次、卖过1次、又买一次股票的最大收益
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            // dp[i][0]表示到第i天为止买过2次、卖过2次股票的最大收益
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);;
        }

        return Math.max(dp[length - 1][2], Math.max(0, dp[length - 1][4]));
    }

    public static void main(String[] args) {
        BuyStock buyStock = new BuyStock();
        int[] prices = new int[]{8,9,2,5,4,7,1};
        int res = buyStock.maxProfit(prices);
        System.out.println(res);
    }
}
