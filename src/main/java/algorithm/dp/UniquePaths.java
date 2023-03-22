package algorithm.dp;

/**
 * @Description:
 * @Author: bsy
 * @Date: 2023/2/16 23:22
 */
public class UniquePaths {
    public int uniquePaths (int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0]=1;
        }
        for(int j=0; j<n; j++){
            dp[0][j]=1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // 回溯办法，复杂度太高
    int count = 0;
    public int uniquePathsBackUp (int m, int n) {
        // write code here

        traverse(0, 0, m, n);
        return count;
    }

    public void traverse(int i, int j, int m, int n){
        if(i>=m || j>=n){return;}
        if(i==m-1 && j==n-1){
            count +=1;
            return;
        }
        traverse(i+1, j, m, n);
        traverse(i, j+1, m, n);

    }
}
