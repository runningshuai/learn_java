package DataType;

public class autoboxingAndUnboxing {
    //new Integer(123) 每次都会新建一个对象；
    //Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。
    //valueOf() 方法的实现比较简单，就是先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
    //在 Java 8 中，Integer 缓存池的大小默认为 -128~127。
    public static void main(String[] args){
        Integer x = new Integer(128);
        Integer y = new Integer(128);
        System.out.println(x==y);

        Integer z = Integer.valueOf(127);
        Integer k = Integer.valueOf(127);
        System.out.println("in -128~127: ");
        System.out.println(z == k);

        Integer p = Integer.valueOf(128);
        Integer q = Integer.valueOf(128);
        System.out.println("not in -128~127: ");
        System.out.println(p == q);

    }

}
