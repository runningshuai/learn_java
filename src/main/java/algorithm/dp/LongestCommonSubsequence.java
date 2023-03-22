package algorithm.dp;

/**
 * @Description: 最长公共子序列,，也可压缩成2*n的数组，最后需要替换，是滚动数组
 * @Author: bsy
 * @Date: 2022/12/5 21:24
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0){
            return 0;
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i=1; i<= m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 新旧数据在一层，<j的是最的，>=j的是旧的(上一层的)，把j位置的数据记下来，下一次使用就变成对角线了
     * 当前j位置是下一层 j + 1的对角线位置
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0){
            return 0;
        }
        int m = text1.length(), n = text2.length();
        // dp = new int[m+1][n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= m; i++) {
            // 第一个元素的左上角初始为0
            int pre = 0;
            for(int j = 1; j <=n; j++) {
                // 上一层的数据
                int temp = dp[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    // dp[i][j] = 1+ dp[i - 1][j - 1];

                    // 上一层的j-1数据是左上角的数
                    dp[j] = 1+pre;
                }else {
                    // dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    dp[j] = Math.max(dp[j-1],dp[j]);
                }
                // 上一层的 j-1
                pre = temp;
            }

        }
        return dp[n];
    }

    /**
     * 返回最长公共子序列的一个子序列
     * @param text1
     * @param text2
     * @return
     */
    public String LCS (String text1, String text2) {
        // write code here
        int m = text1.length();
        int n = text2.length();
        if(m <= 0 || n <= 0){
            return "-1";
        }
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        // 找路径
        StringBuilder sb = new StringBuilder();
        int i=m, j=n;
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i -=1;
                j -=1;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i -=1;
            }else {
                j -=1;
            }
        }
        if(sb.length() == 0){return "-1";}
        return sb.reverse().toString();
    }




    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        String s1 = "qwerty";
        String s2 = "1w2ry";
        int res = solution.longestCommonSubsequence2(s1, s2);
        System.out.println(res);
        System.out.println("---------------------");

        String lcs = solution.LCS(s1, s2);
        System.out.println(lcs);
    }
}
