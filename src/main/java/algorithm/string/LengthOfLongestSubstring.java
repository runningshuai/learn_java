package algorithm.string;

import java.util.HashMap;

/**
 * @Description: 无重复的最长子串
 * @Author: bsy
 * @Date: 2023/2/7 13:30
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){return s.length();}
        HashMap<Character, Integer> window = new HashMap<>();

        int left=0, right=0, res=0;
        while(right < s.length()){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right +=1;
            //存在重复，把第一个重复的及之前的全部干掉
            while(window.get(c)>1){
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                left +=1;
            }

            res = Math.max(res, right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String s = "pwwkew";
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);

    }
}
