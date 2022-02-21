package learnProxy;

public class maYun implements Person {

    public String eat(String food){
        System.out.println("eat: " + food);
        return "full ge~";
    }

    public String work(String job){
        System.out.println("make money: " + job);
        return "money ~";
    }
}
