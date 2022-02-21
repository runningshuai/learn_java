package innerFunction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class learn_collectors {
    public static void main(String[] args){
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        boolean flag;
        flag = Arrays.equals(new int[] {1,2,3}, new int[]{1, 2, 3});
        int [] a = new int[] {1, 2, 3};
        System.out.println(a.length);


        System.out.println("flag "+ flag);
        List<String> filtered = strings1.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("raw" + strings1);
        System.out.println("筛选列表" + filtered);

        String filtered2 = strings1.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串" + filtered2);
    }
}
