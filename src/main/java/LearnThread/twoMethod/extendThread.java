package LearnThread.twoMethod;

/**
 * 继承Thread类，创建一个新的线程对象。
 * 完成线程的方法在run方法中，继承thread类之后就可以覆盖父类的run方法，调用start方法，也就调用了run方法
 */
public class extendThread extends Thread {
    private int count = 10;

    /**
     * 从大到小，数字递减打印
     */
    public void run(){
        while (true){
            System.out.print(count + " ");

            if (--count ==0 ){
                return;
            }
        }
    }

    public static void main(String[] args) {
        new extendThread().start();
    }
}
