package learnArray;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        //初始化为0
        int[] arr1 = new int[3];
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 = {1,2,3};
        int[] arr4 = null;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        //NullPointerException空指针异常
        System.out.println(arr4[1]);
    }
}
