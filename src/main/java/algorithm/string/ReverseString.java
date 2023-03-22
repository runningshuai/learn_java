package algorithm.array.string;

/**
 * @Description:反转字符串数组 输入：s = ["h","e","l","l","o"], 输出：["o","l","l","e","h"]
 * @Author: bsy
 * @Date: 2022/12/1 23:07
 */
public class ReverseString {
    public void reverseString(char[] s){
        if(s.length <= 1){
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while(left < right){
            // 相撞指针，对元素进行交换
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left = left + 1;
            right = right - 1;
        }
    }

}
