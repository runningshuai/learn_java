package api;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LearnRandom {
    public static void main(String[] args) {
        List<String> symbolList = new ArrayList<>();
        Random random = new Random();
        int index = random.nextInt(symbolList.size());
        System.out.println("random result is: " + index);
    }
}
