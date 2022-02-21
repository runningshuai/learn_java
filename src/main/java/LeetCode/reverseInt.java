package LeetCode;
//翻转整形数字
public class reverseInt {
    public int reverse(int x) {
        int temp=0;
        int pop=0;
        while(x!=0){
            if (temp > Integer.MAX_VALUE/10 || temp == Integer.MAX_VALUE / 10 && pop >Integer.MAX_VALUE%10){
                return 0;
            }
            if (temp < Integer.MIN_VALUE/10 || temp == Integer.MIN_VALUE/10 && pop <Integer.MIN_VALUE%10){
                return 0;
            }
            pop = x%10;
            temp = temp*10 + pop;
            x = x/10;
        }
        return temp;
    }

    public static void main(String[] args) {
        reverseInt r = new reverseInt();
        int result = r.reverse(567);
        System.out.println(result);
    }
}
