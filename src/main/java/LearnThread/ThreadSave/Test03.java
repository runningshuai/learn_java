package LearnThread.ThreadSave;

public class Test03 implements Runnable {
    int num = 10;

    @Override
    public void run() {
        while (true) {
            doit();
        }
    }

    //同步方法
    public synchronized void doit(){
        if (num > 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("tickets: " +num--);
        }
    }

    public static void main(String[] args) {
        Test03 t = new Test03();
        Thread tA = new Thread(t);
        Thread tB = new Thread(t);
        Thread tC = new Thread(t);
        Thread tD = new Thread(t);

        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }
}
