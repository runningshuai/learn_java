package ds.sort.dynamicPogram;

/**
 * 买卖股票的最大收益
 * [8,9,2,5,4,7,1] --> 5
 * 动态规划算法的基本思想是：将待求解的问题分解成若干个相互联系的子问题，
 * 先求解子问题，然后从这些子问题的解得到原问题的解；
 * 对于重复出现的子问题，只在第一次遇到的时候对它进行求解，
 * 并把答案保存起来，让以后再次遇到时直接引用答案，不必重新求解。
 * 动态规划算法将问题的解决方案视为一系列决策的结果
 */
public class buyStock {
    public static int maxProfit (int[] prices) {
        // write code here

        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0]= 0; //不持股
        dp[0][1]=-prices[0]; // 持股
        for(int i=1; i< n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
        }

        return dp[n-1][0];
    }

    public static int[][] maxProfitPrint (int[] prices) {
        // write code here

        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0]= 0; //不持股
        dp[0][1]=-prices[0]; // 持股
        for(int i=1; i< n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
        }

        return dp;
    }

    public static void main(String[] args) {
//        int[] arr = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int[] arr = new int[] {1,2};
//        int[] arr = new int[]{8, 9, 2, 5, 4, 7, 1};
        int res = maxProfit(arr);
        System.out.println(res);

        int[][] dp = maxProfitPrint(arr);

        for (int m = 0; m < dp[1].length; m++) {
            for (int n = 0; n < dp.length; n++) {
                System.out.print(dp[n][m] + " ");
            }
        }
    }
}
