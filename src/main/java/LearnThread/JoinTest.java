package LearnThread;

import javax.swing.*;
import java.awt.*;

public class JoinTest extends JFrame {

    //定义两个
    private Thread threadA;
    private Thread threadB;

    //定义进度条
    final private JProgressBar progressBar = new JProgressBar();
    final private JProgressBar progressBar2 = new JProgressBar();

    int count = 0;
    public static void main(String[] args) {
        init(new JoinTest(), 500, 500);
    }

    private JoinTest() {
        super();
        //最北面
        getContentPane().add(progressBar, BorderLayout.NORTH);
        //最南面
        getContentPane().add(progressBar2, BorderLayout.SOUTH);
        progressBar.setStringPainted(true);
        progressBar.setBorderPainted(true);

        progressBar2.setStringPainted(true);
        progressBar2.setBorderPainted(true);

        //初始化thread
        threadA = new Thread(new Runnable() {
            int count = 0;

            public void run() {
                while (true) {
                    progressBar.setValue(++count);
                    try {
                        Thread.sleep(100);
                        threadB.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();

        threadB = new Thread(new Runnable() {
            int count = 0;

            public void run() {
                while (true) {
                    progressBar2.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (count == 100) break;
                }
            }
        });
        threadB.start();
    }
        private static void init(JFrame frame, int width, int height){
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(width, height);
            frame.setVisible(true);
        }
}
