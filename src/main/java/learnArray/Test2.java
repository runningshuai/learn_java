package learnArray;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("raw: "+Arrays.toString(arr));
        printArray(arr);
        //引用类型的变量作为参数传递给方法时，传递的时地址值，Array是引用类型
        //基本类型的变量作为参数传递时，是值传递
        System.out.println("now: "+Arrays.toString(arr));

    }

    public static void printArray(int[] array){
        for (int i=0; i<array.length; i++){

            System.out.println(array[i]);
            array[i] = array[i] + 1;
        }
    }
}
