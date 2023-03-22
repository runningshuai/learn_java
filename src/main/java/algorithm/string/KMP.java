package algorithm.string;

import java.util.Arrays;

/**
 * @Description:
 * @Author: bsy
 * @Date: 2023/2/12 23:56
 */
public class KMP {
    public int strStr(String haystack, String needle){
        if(needle.length() == 0) {return 0;}
        int[] next = new int[needle.length()];
        getNext(next, needle);
        System.out.println(Arrays.toString(next));

        int j=0;
        for(int i=0; i<haystack.length(); i++){
            while(j>0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){j++;}
            if(j==needle.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

    public void getNext(int[] next, String s){
        int j=0;
        next[0] = 0;
        for(int i=1; i<s.length(); i++){
            //if在前面，j会被改变两次
            while(j>0 && s.charAt(i) != s.charAt(j)){
                // j的上一个状态是j-1, 前缀【0， j-1】
                j = next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){j++;}
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String s1 = "mississippi";
        String s2 = "issip";
        int res = kmp.strStr(s1, s2);
        System.out.println(res);
    }
}
