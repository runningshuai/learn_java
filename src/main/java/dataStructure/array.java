package dataStructure;

import java.util.Arrays;
import java.util.Comparator;

public class array {

    public static void main(String[] args) {
        //数组定义
        //声明，开辟空降，赋值
        int[] myArray;
        myArray = new int[5];
        for(int i=1; i<myArray.length; i++){
            //数据元素的访问通过索引来实现
            myArray[i] = i+1;
        }

        //声明&开辟空间，赋值
        int[] myArray02 = new int[5];
        //声明&开辟空间&赋值
        int[] myArray03 = {1, 2, 3, 4, 5};
        //等价于
        int[] myArray04 = new int[] {6, 1, 2, 3, 4, 5};

        //统计
        System.out.println("myArray04.length: " + myArray04.length);

        //排序，从小到大
        Arrays.sort(myArray04);
        System.out.println("排序后: " + Arrays.toString(myArray04));

        //排序，从大到小.没有从大到小的方法，需要重新定义Comparator
        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        //Arrays进行从大到小的排序，所排序的必须是Integer对象，否则将出错，
        // 也即a中的数据类型必须是Integer类型，不能是int类型。
        Integer[] myArray05 = new Integer[]{2, 2, 4, 7, 1};
        Arrays.sort(myArray05, cmp);
        System.out.println("从大到小排序后: " + Arrays.toString(myArray05));
    }

}
