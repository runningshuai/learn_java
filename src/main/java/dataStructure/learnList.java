package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class learnList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);
        System.out.println("values of list: " + list);

        //测试空list的join方法
        List<String> listForJoin = new ArrayList<>();
        System.out.println("空列表join: " + String.join(",", listForJoin));

        //访问元素
        System.out.println("通过get方法获取list的第2个元素： " + list.get(1));
        //修改元素
        System.out.println("通过set方法修改list的第2个元素： " + list.set(1, "bb"));


        //迭代
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
        System.out.println("迭代list元素结束...");

        List<HashMap> listMap = new ArrayList<>();

        listMap.add(new HashMap());
        System.out.println(listMap.size());

        System.out.println(listMap.isEmpty());


    }
}
