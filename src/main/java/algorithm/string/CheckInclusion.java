package algorithm.string;

import java.util.HashMap;

/**
 * @Description: 字符串排列，判断s2是否包含s1的排列
 * @Author: bsy
 * @Date: 2023/2/7 11:34
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){return false;}
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char s = s1.charAt(i);
            need.put(s, need.getOrDefault(s, 0) + 1);
        }

        int left=0, right=0, valid=0;
        while(right<s2.length()){
            //窗口右移
            char c = s2.charAt(right);
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                //包含字符且数量相等，说明满足条件
                if(need.get(c).equals(window.get(c))){
                    valid +=1;
                }
            }
            right +=1;

            //找到满足条件的
            if(right - left >= s1.length()){
                if(valid==need.size()){
                    return true;
                }
                //当前窗口不满足条件，左窗口滑动
                c = s2.charAt(left);
                if(window.containsKey(c)){
                    //先判断
                    if(window.get(c).equals(need.get(c))){
                        valid -=1;
                    }
                    // 后更新窗口，(和进窗口相反的操作 )
                    window.put(c, window.getOrDefault(c, 0) - 1);
                }
                left +=1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1="ab";
        String s2 = "eidboaoo";

        CheckInclusion solution = new CheckInclusion();
        boolean b = solution.checkInclusion(s1, s2);
        System.out.println(b);
    }
}
