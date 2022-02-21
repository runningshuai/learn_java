package dataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class learnMap {

    public static void main(String[] args){

        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        System.out.println("Raw map: " + map);
        System.out.println("遍历key " + map.keySet());
        System.out.println("遍历value " + map.values());

        //取值
        System.out.println("get a: " + map.get("a"));
        System.out.println("get d: " + map.getOrDefault("d", ""));

        //判断key是否存在
        System.out.println("contains d?: " + map.containsKey("d"));


        //遍历key，取value
        System.out.println("遍历key，取value");
        for(String key: map.keySet()){
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        //遍历value
        System.out.println("遍历values");
        for(String v: map.values()){
            System.out.println("value= " + v);

        }

        //遍历entrySet
        System.out.println("通过iterator遍历entrySet" + map.entrySet());
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry= it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());

        }
    }
}
