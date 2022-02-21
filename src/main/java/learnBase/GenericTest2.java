package learnBase;

import java.util.List;
import java.util.ArrayList;

public class GenericTest2 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("mary");
        age.add(16);
        number.add(13);

        getData(name);
        getData(age);
        getData(number);

    }

    public static void getData(List<?> data){
        System.out.println(data.get(0));
    }
}
