package LearnThread.twoMethod;

public class runnableThread {

    private static int count = 10;

    static class MyRunnable implements Runnable{

        /**
         * 从大到小，数字递减打印
         */
        @Override
        public void run(){
            while (true){
                System.out.print(count + "-runnable ");

                if (--count ==0 ){
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();
        Thread thread = new Thread(my);
        thread.start();
    }


}



