package learnReflection;

/** Reflection是java被视为动态语言的关键，反射允许程序在执行期间
 * 借助于Reflection API取得任何类内部的信息，并可以直接操作对象的
 * 内部属性及方法
 *  java是静态语言，python和js是动态语言*/

public class testReflection extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("learnReflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("learnReflection.User");
        Class c3 = Class.forName("learnReflection.User");
        Class c4 = Class.forName("learnReflection.User");

        /**一个类在内存中只有一个class对象
         * 一个类被加载后，类的整个结构都会被封装在class对象中 */
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        User user = new User();
        Class c5 = user.getClass();
        /** 获取父类*/
        Class c6 =  c5.getSuperclass();
        System.out.println(c5.hashCode());
        System.out.println(c6);
        Class c7 = User.class;
        System.out.println(c7.hashCode());
    }

}

/* 只能有一个public类，这个不能加public*/
/** 实体类 */
class User{
    private String name;
    private int id;
    private int age;

    /** 无参构造器 */
    public User(){
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}