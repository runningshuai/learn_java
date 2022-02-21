package LearnThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class testThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i=0; i<=5; i++){
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added: " + task.getName());
            executor.execute(task);
        }
        executor.shutdown();
    }
}

class Task implements Runnable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run(){
        Long duration = (long)(Math.random()*10);
        System.out.println("Doing a task during: " + name);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

