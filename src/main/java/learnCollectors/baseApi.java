package learnCollectors;

import java.util.*;
import java.util.stream.Collectors;

public class baseApi {

    public static void main(String[] args) {
        String[] arr = {"123", "aa", "bbb", "ddd", "aa"};
        List<String> strings = Arrays.asList(arr);

        //toSet,由list直接创建hashset
        Set<String> testSet = new HashSet<>(strings);
        System.out.println("toSet: " + testSet);

        //joining
        String testJoin = strings.stream().collect(Collectors.joining("-"));
        System.out.println("testJoin: " + testJoin);

        //maping
        List<Integer> testMapping = strings.stream()
                .filter(item -> item.matches("[0-9]+"))
                .collect(Collectors.mapping(Integer::valueOf, Collectors.toList()));
        System.out.println("testMapping: " + testMapping);

        //counting
        Long testCount = strings.stream().collect(Collectors.counting());
        System.out.println("testCounting: " + testCount);

        //groupingBy
        Map<Integer, List<String>> testGroupingBy = strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("testGroupingBy: " + testGroupingBy);

        // partitioningBy, key is boolean
        Map<Boolean, List<String>> testPartitioningBy = strings.stream().collect(Collectors.partitioningBy(item -> item.length() > 2));
        System.out.println("testPartitioningBy: " + testPartitioningBy);




    }

}
