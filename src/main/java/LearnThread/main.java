package LearnThread;

public class main {
    public static void main(String[] args) {
        //错误调用方法
        System.out.println("------> wrong method: ");
        for(int i=0; i<=3; i++) {
            myThread t1 = new myThread();
            t1.start();
        }

        System.out.println("-------- >right method: ");
        myThread t2 = new myThread();
        for(int j=0; j<=3; j++){
            Thread t3 = new Thread(t2);
            t3.start();

        }
    }
}
