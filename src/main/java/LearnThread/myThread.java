package LearnThread;

public class myThread extends Thread{
    private int ticket = 10;

    public void run() {
        while (true){
            System.out.println("Thread ticket ==" + ticket--);
            if (ticket < 0){
                break;
            }
        }
    }

}
