package LearnThread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SleepMethod extends JFrame {
    private Thread t;
    private static Color[] color = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE,
                        Color.YELLOW, Color.RED, Color.PINK, Color.LIGHT_GRAY};

    private static final Random rand = new Random();
    private static Color getC(){
        return color[rand.nextInt(color.length)];
    }

    public SleepMethod(){
        t = new Thread(new Runnable(){
            int x = 50;
            int y = 50;
            public void run(){
                while (true){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    Graphics graphics = getGraphics();
                    graphics.setColor(getC());
                    graphics.drawLine(x, y, 1000, y);
                    y +=10;
                    if(y>=400){
                        y=50;
                    }
                }
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        init(new SleepMethod(), 1000, 500);
    }

    private static void init(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
