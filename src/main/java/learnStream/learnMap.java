package learnStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class learnMap {

    public static void main(String[] args) {
        String longItem = "CSI123^12#F12345^2";
        List<String> collect = Arrays.stream(longItem.split("#")).map(x -> x.split("\\^")[0]).collect(Collectors.toList());
        System.out.println(collect);
    }
}
