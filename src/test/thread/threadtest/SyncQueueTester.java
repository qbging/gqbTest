package test.thread.threadtest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 容量1的阻塞队列 ArrayBlockingQueue输出结果： 0 1 5 10 15（队列只留一个任务）
 *表明：一个线程执行1秒，跳过5次循环，改为SynchronousQueue是0容量的阻塞队列，不会缓存任务 即输出0 5 10 15 
 */
public class SyncQueueTester {	
    private static ExecutorService executor = new ThreadPoolExecutor(1, 1,
            1000, TimeUnit.SECONDS,   
            new ArrayBlockingQueue<Runnable>(1),  
            new ThreadPoolExecutor.DiscardPolicy());  
  
    public static void main(String[] args) throws InterruptedException {  
        for (int i = 0; i < 20; i++) {  
            kickOffEntry(i);  
            Thread.sleep(210);//一个线程执行1秒，跳过5次循环
        }  
        executor.shutdown();  
    }  
    private static void kickOffEntry(final int index) {  
        executor.  
            submit(  
                new Callable<Void>() {  
                    public Void call() throws InterruptedException {  
                        System.out.println("start " + index);  
                        Thread.sleep(1000); // pretend to do work  
                        System.out.println("stop " + index);  
                        return null;  
                    }  
                }  
            );  
    }  
}