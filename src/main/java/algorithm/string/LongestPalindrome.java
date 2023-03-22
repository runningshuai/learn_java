package algorithm.string;

/**
 * @Description: 最长回文字符串; 输入：s = "babad", 输出："bab"
 * 使用扩散指针，可能有偶数回文和奇数回文
 * @Author: bsy
 * @Date: 2022/12/1 23:18
 */
public class LongestPalindrome {

    String longestPalindrome(String s){
        if(s.isEmpty()){return null;}
        if(s.length()==1){return s;}
        //记录最大的开始和结束指针，同时可以计算出长度
        int start=0, end=0;
        for(int i=0; i< s.length(); i++){
            int a = findPalindrome(s, i, i);
            int b = findPalindrome(s, i, i+1);
            int length = Math.max(a, b);
            // 是否大于目前最大的回文长度
            if(length > end - start + 1){
                //分奇数和偶数推导出 start, end然后综合得出
                start = i - (length - 1)/2;
                end = i + length/2;
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * 从中间位置向两边扩展寻找回文串, left=right寻找奇数的回文，不相等寻找偶数的回文
     * 在 s 中寻找以 s[left] 和 s[right] 为中心的最长回文串
     */
    int findPalindrome(String s, int left, int right){
        // 边界
        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        // 最后指针已经跳出回文了，right-1 - (left + 1) + 1
        return right - left - 1;

    }

    public static void main(String[] args) {
        System.out.println(3.0/2);
        System.out.println(3/2);
    }
}
