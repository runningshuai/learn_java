package DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class learnDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());

        Date date1 = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(ft.format(date1));
        long now = System.nanoTime();
        System.out.println(now);
        System.out.println("currentTimeMillis: " + System.currentTimeMillis());

    }
}
