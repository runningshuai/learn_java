package LearnThread;

import javax.swing.*;
import java.awt.*;

public class InterruptedMethod extends JFrame {
    Thread thread;

    public static void main(String[] args) {
        init(new InterruptedMethod(), 1000, 500);
    }

    public InterruptedMethod(){

        JProgressBar progressBar = new JProgressBar();
        getContentPane().add(progressBar, BorderLayout.NORTH);
        progressBar.setBorderPainted(true);

        thread = new Thread(new Runnable(){
            int count = 0;

            @Override
            public void run() {
                while(true){
                    progressBar.setValue(count);
                    ++count;

                    try {
                        Thread.sleep(5000);
                    }catch(InterruptedException e){
                        System.out.println("当前线程中断");
                        break;
                    }
                }
            }
        });

        thread.start();
        thread.interrupt();
    }

    public static void init(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
