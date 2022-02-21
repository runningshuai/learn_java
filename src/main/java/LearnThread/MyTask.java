package LearnThread;

public class MyTask implements Runnable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTask(String name){
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println(this.toString() + "is running");
        //任务执行的时间
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "MyTask [name=" + name + "]";
    }
}
