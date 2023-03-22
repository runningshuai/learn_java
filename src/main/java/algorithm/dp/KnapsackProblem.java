package algorithm.dp;

/**
 * @Description: 0-1背包问题，给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * @Author: bsy
 * @Date: 2022/12/7 16:58
 */
public class KnapsackProblem {

    int knapsnack(int W, int N, int[] wt, int[] val){
        //定义dp[i][j]为最大价值, i为0-i个物品, j为重量
        int[][] dp = new int[N+1][W+1];
        //base case 为0，默认已经初始化
        for(int i=1; i<=N; i++){
            for(int j=1; j<=W; j++){
                //装不进去
                if(j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(
                            val[i] + dp[i-1][j - wt[i-1]],
                            dp[i-1][j]

                    );
                }
            }
        }
        return dp[N][W];
    }
}
