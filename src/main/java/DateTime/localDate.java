package DateTime;

import java.sql.Timestamp;
import java.time.LocalDate;

public class localDate {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("now: " + now);

        long l = now.toEpochDay();
        System.out.println("toEpochDay is: " + l);

        long dayDiff = now.toEpochDay() - now.toEpochDay();
        System.out.println("dayDiff is: " + dayDiff);

        LocalDate localDate = new Timestamp(1644807152).toLocalDateTime().toLocalDate();
        System.out.println("localDate: " + localDate);


    }
}
