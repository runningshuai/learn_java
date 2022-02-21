package learnVariable;

//成员变量与局部变量

public class Test01 {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "子轩";
        student.age=18;
        //打印 紫萱is working.变量的赋值采用"就近原则"
        student.study();

    }
}

class Student{
    String name;
    int age;
    public void study(){
        String name="紫萱";
        System.out.println(name + "is working.");
    }
}
