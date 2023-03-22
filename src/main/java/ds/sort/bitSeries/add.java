package ds.sort.bitSeries;

public class add {
    /*
    不用加减乘除做加法
    1、不进位加法：a^b
    2、进位：a&b
    后续循环进位就行了，直到进位为0
     */
    private static int Add(int num1,int num2){
        int sum = num1 ^ num2; //无进位加法
        int carry = (num1 & num2)<<1; //进位

        while (carry !=0 ){
            int a = sum;
            int b = carry;
            sum = a ^ b;
            carry = (a & b)<<1;
        }
        return sum;
    }
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int result = Add(a, b);
        System.out.println("sum of " + a + " and " + b + " is " + result);
    }
}
