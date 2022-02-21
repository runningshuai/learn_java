package LearnThread;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
* 序号	名称	类型	含义
1	corePoolSize	int	核心线程池大小
2	maximumPoolSize	int	最大线程池大小
3	keepAliveTime	long	线程最大空闲时间
4	unit	TimeUnit	时间单位
5	workQueue	BlockingQueue<Runnable>	线程等待队列
6	threadFactory	ThreadFactory	线程创建工厂
7	handler	RejectedExecutionHandler	拒绝策略

* */
public class testThread {

    //psvm+tab键就可以自动生成
    public static void main(String[] args) throws IOException {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new MyThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        //预启动所有核心线程
        for(int i=1; i<=10; i++){
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }
        System.in.read(); //阻塞主线程
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e){
            System.err.println(r.toString() + " rejected");
        }
    }

    public static class MyThreadFactory implements ThreadFactory{
        private final AtomicInteger myThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + myThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created!");
            return t;
        }
    }




}
