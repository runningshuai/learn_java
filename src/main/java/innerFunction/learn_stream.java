package innerFunction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class learn_stream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "r", "","aad", " ");
        List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        //forEach
        Random random = new Random();
        random.ints(10).filter(x -> x < 0).forEach(System.out::println);

        //map,映射每个元素对应得结果
        List<Integer> numbers = Arrays.asList(3,4,5,5,6,76);
        List<Integer> squreList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squreList);

        //filter,设置条件过滤元素
        List<String> strings2 = Arrays.asList("wee", "sedrg", "erwr", " ", "");
        long count = strings2.stream().filter(x -> x.isEmpty()).count();
        System.out.println(count);

        //sorted
        Random random2 = new Random();
        random2.ints().limit(10).sorted().forEach(x -> System.out.print(x + ","));
        System.out.println();

        //parallelStream 并行程序
        List<String> strings3 = Arrays.asList("acv", "ad", "re", "er", "34", " ", "");
        long num = strings3.parallelStream().filter(s -> ! s.isEmpty()).count();
        System.out.println(num);
    }
}
