package learnAtomic;

import java.util.concurrent.atomic.AtomicLong;

public class test implements Runnable {

    private static final AtomicLong num = new AtomicLong();

    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() + ":" + num.getAndIncrement()
        );
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test t = new test();

        for (int i=0; i<=10; i++){
            Thread tt = new Thread(t, "myThreadTest" + i);
            tt.start();
        }
    }
}
