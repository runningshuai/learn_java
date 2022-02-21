package learnGson;

import com.google.gson.Gson;
/*Gson提供了fromJson和toJson两个直接用于解析和生成的方法*/

public class test {
    public static void main(String[] args){
        Gson gson = new Gson();
        int n = gson.fromJson("250", int.class);
        double d = gson.fromJson("12.34", double.class);
        boolean b = gson.fromJson("true", boolean.class);
        //这个方法只接受字符,其他特殊符号不行
        String s = gson.fromJson("hellow8", String.class);
        System.out.println("------fromJson------");
        System.out.println(n);
        System.out.println(d);
        System.out.println(b);
        System.out.println(s);

        Gson gson2 = new Gson();
        String s1 = gson2.toJson(250);
        String s2 = gson2.toJson(true);
        System.out.println("------ToJson------");
        System.out.println(s1 + "," + s2);
    }

}
