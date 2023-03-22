package algorithm.backTrack.PermuteCombineSubsets;

/**
 * @Description: 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）
 * @Author: bsy
 * @Date: 2023/2/8 15:45
 */
public class StrStr {
    public int strStr(String haystack, String needle){
        if(haystack.length() < needle.length()){
            return -1;
        }

        int i=0, j=0;
        while(i + j<haystack.length()&&j<needle.length()){
            //i不动，可以记录起始位置
            if(haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }else{
                i++;
                j=0;
            }
        }
        return j==needle.length()?i:-1;
    }

    public static void main(String[] args) {
        StrStr solution = new StrStr();
        String haystack = "sadbutsad";
        String needle = "sad";
        int res = solution.strStr(haystack, needle);
        System.out.println(res);
    }
}
