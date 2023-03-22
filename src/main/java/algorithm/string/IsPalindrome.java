package algorithm.string;

/**
 * @Description: 判断是否回文字符串
 * @Author: bsy
 * @Date: 2022/12/1 23:14
 */
public class IsPalindrome {
    boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }
}
