package learnInterface;

public class cat implements Animal{

    public void eat() {
        System.out.println("mao liang");
    }

    public int getAge() {
        return 1;
    }

    public static void main(String[] args){
        cat cc = new cat();
        cc.eat();
        int age = cc.getAge();
        System.out.println(age);
    }
}
