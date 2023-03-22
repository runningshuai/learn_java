package algorithm.string;

import java.util.HashMap;

/**
 * @Description: 最小覆盖子串， S中包含T的最小子串
 * @Author: bsy
 * @Date: 2023/2/6 21:18
 */
public class MinWindow {
    public String minWindow (String S, String T) {
        // write code here
        String res = "";
        if(S.length() < T.length()){return res;}

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        //构造need，用来判断是否匹配
        for(int i=0; i<T.length(); i++){
            need.put(T.charAt(i), need.getOrDefault(T.charAt(i), 0) + 1);
        }

        //判断字符的个数是否相等
        int valid=0;
        //滑动窗口的左右边界，结束条件是遍历完S
        int left=0, right=0;
        int minLength = S.length() + 1;
        // 记录字符串的位置，用于截取字符串
        int start = 0;
        while(right < S.length()){
            //开始扩大窗口
            char s = S.charAt(right);
            if(need.containsKey(s)){
                window.put(s, window.getOrDefault(s, 0) + 1);
                //字符数量相等，满足条件
                if(need.get(s).equals(window.get(s))){
                    valid +=1;
                }
            }
            //下面的代码不包括right
            right +=1;

            //找到了一个符合条件的子串，接着需要缩短左边界，if只能缩短1次，需要用while
            while(valid==need.size()){
                if(right - left < minLength){
                    start = left;
                    minLength = right - left;
                }

                s = S.charAt(left);
                //缩小左边界，窗口要调整
                left += 1;
                if(need.containsKey(s)){
                    if(need.get(s).equals(window.get(s))){
                        valid -=1;
                    }
                    window.put(s, window.get(s) - 1);
                }
            }
        }
        return minLength==S.length() + 1 ? res:S.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String S = "abccdfgyskl";
        String T = "bccd";
        String result = minWindow.minWindow(S, T);
        System.out.println(result);
    }
}
