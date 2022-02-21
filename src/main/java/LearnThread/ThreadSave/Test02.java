package LearnThread.ThreadSave;

public class Test02 implements Runnable {
    int num = 10;

    @Override
    public void run() {
        while (true) {
            //同步块
            synchronized ("") {
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("tickets" +num--);

                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test02 t = new Test02();
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
