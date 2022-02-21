package learnBase;

import java.util.ArrayList;
import java.util.List;

public class list {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.addAll(list1);
        String s = list1.toString();
        System.out.println(s);
        list1.remove(0);
        System.out.println("删除后" + list1.toString());
        list1.removeAll(list1);
        System.out.println("删除所有后" + list1.toString());


    }

}
