package DateTime;

import java.util.concurrent.TimeUnit;

public class base {
    public static void main(String[] args){
        System.out.println(TimeUnit.MILLISECONDS);
        System.out.println(TimeUnit.SECONDS);
        System.out.println(TimeUnit.MINUTES);
        System.out.println(TimeUnit.HOURS);
        System.out.println(TimeUnit.DAYS);
        System.out.println( TimeUnit.DAYS.toHours( 1 ) );
        //把3天转化成小时
        System.out.println( TimeUnit.HOURS.convert( 3 , TimeUnit.DAYS ) );
    }
}
