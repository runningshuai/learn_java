package LeetCode;

//判断是否回文数
public class isPalindrome {
    public boolean Palindrome(int x) {
        if(x<0 || x%10==0 && x !=0){
            return false;
        }
        int reversedNumber=0;
        while(x>reversedNumber){
            //注意这两个的顺序
            reversedNumber =  reversedNumber * 10 + x%10;
            x /= 10;
        }
        return x == reversedNumber || x == reversedNumber / 10;
    }

    public static void main(String[] args) {
        isPalindrome palindrome = new isPalindrome();
        System.out.println(palindrome.Palindrome(121));
    }
}
