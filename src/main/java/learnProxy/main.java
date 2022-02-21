package learnProxy;

public class main {
    public static void main(String[] args){
        myProxy myproxy = new myProxy();

        Person p = myproxy.getProxy();

        String res = p.eat("apple");
        System.out.println(res);


        String job = p.work("淘宝");

        System.out.println(job);
    }
}










