package ds.sort.dynamicPogram;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 连续子串
 */
public class llengthOfLongestSubstring {
    public static int lengthOfLongestSubstring (String s) {
        // write code here
        if(s.length()<=1) return s.length();
        HashMap<Character, Integer> map = new HashMap();
        int i=0;
        int max=1;
        map.put(s.charAt(0), 0);
        for(int j=1; j<s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            max = (j-i + 1) > max ?  (j-i + 1): max;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabdabc";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
