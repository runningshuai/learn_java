package learnBase;

import java.util.Arrays;

public class GenericTest {
    public static <E> void printArray(E[] inputArray){
        for (E e: inputArray){
            System.out.printf("%s ", e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.0, 2.1, 3.3, 4.4, 5.5};
        Character[] charArray = {'W', 'O', 'R', 'L', 'D'};

        System.out.println("intArray");
        printArray(intArray);

        System.out.println("doubleArray");
        printArray(doubleArray);

        System.out.println("character");
        printArray(charArray);
        String s = "hello, world";
        //返回的是数组
        String[] s2 = s.split(",");
        Arrays.asList(s2).forEach(item -> System.out.println(item));
        Arrays.asList(s2).forEach(System.out::println);


    }
}
