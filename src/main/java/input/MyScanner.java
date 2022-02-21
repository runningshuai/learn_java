package input;

import java.util.Scanner;

public class MyScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数： ");
        int n = sc.nextInt();
        // 输入任何变量+"" 都会转化成字符串
        System.out.println("your input is" + n);
    }
}
