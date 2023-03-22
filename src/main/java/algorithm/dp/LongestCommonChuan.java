package algorithm.dp;

import java.util.Arrays;

/**
 * @Description: 循环遍历一个元素一个元素进行匹配，如果相等要看上一个元素是否相等，且上一个相等的元素在其对角线位置，
 * 若相等要加上之前的，若不相等，说明不匹配，直接为0(因为就是要看这俩元素是否相等，不相等为0)
 * https://blog.nowcoder.net/n/5cc2e0f7a0ce43cfbc6b6d318df8ebca?f=comment
 * @Author: bsy
 * @Date: 2023/2/16 20:59
 */
public class LongestCommonChuan {

    public String LCS(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        if(m==0 || n==0){
            return "-1";
        }

        int[][] dp = new int[m+1][n+1];
        int maxLength = 0;
        int end = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    //把相等的元素串联起来
                    dp[i][j] = dp[i-1][j-1] + 1;
                    //一直更新
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        end = i-1;
                    }
                }else{

                    dp[i][j] = 0;
                }
            }
        }
        return text1.substring(end - maxLength + 1, end+1);
    }



    public String LCSV2(String str1, String str2){
        //记录最长公共子串的长度
        int maxLenth = 0;
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int maxLastIndex = 0;
        int[] dp = new int[str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            System.out.println("----i" + i);
            //注意这里是倒叙
            for (int j = str2.length() - 1; j >= 0; j--)
            {
                System.out.println("----j" + j);
                //递推公式，两个字符相等的情况
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[j + 1] = dp[j] + 1;
                    System.out.println(Arrays.toString(dp));
                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
                    //以及最长子串最后一个元素的位置
                    if (dp[j + 1] > maxLenth) {
                        maxLenth = dp[j + 1];
                        maxLastIndex = i;
                    }
                } else {
                    //递推公式，两个字符不相等的情况
                    dp[j + 1] = 0;
                }
            }
        }
        //最字符串进行截取，substring(a,b)中a和b分别表示截取的开始和结束位置
        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex + 1);
    }

    public static void main(String[] args) {
        String s1 = "qwert";
        String s2 = "1qwe2r";
        LongestCommonChuan longestCommonChuan = new LongestCommonChuan();
        String lcs = longestCommonChuan.LCS(s1, s2);
        System.out.println(lcs);

        String lcs2 = longestCommonChuan.LCSV2(s1, s2);
        System.out.println(lcs2);
    }
}
