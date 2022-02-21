package input;

import java.util.Scanner;
public class input {
    public static void main(String[] args) {
        System.out.println("请输入: ");
        Scanner input = new Scanner(System.in);
        //默认string格式
        String s1 = input.next();
        System.out.println(s1);
        Integer s2 = input.nextInt();
        System.out.println(s2);
    }
}


