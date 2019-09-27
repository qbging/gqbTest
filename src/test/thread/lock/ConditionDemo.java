package test.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用lock和condition实现B线程先打印一句信息后，然后A线程打印两句信息（不能中断），交替十次后结束
 */
public class ConditionDemo {
    volatile int key = 0;
    Lock l = new ReentrantLock();
    Condition c = l.newCondition();
    
    public static  void main(String[] args){
        ConditionDemo demo = new ConditionDemo();
        new Thread(demo.new A()).start();
        new Thread(demo.new B()).start();
    }
    
    class A implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i > 0){
                l.lock();
                try{
                    if(key == 1){
                        System.out.println("A is Running");
                        System.out.println("A is Running");
                        i--;
                        key = 0;
                        // 借助条件，唤醒等待队列的线程B。
                        c.signal();
                    }else{
                        // 进入等待队列。释放锁标记。
                        // 借助条件，进入的等待队列。
                     c.awaitUninterruptibly();                        
                    }
                    
                }
                finally{
                    l.unlock();
                }
            }
        }
        
    }
    
    class B implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i > 0){
                l.lock();
                try{
                    if(key == 0){
                        System.out.println("B is Running");
                        i--;
                        key = 1;
                        c.signal();
                    }else{
                     c.awaitUninterruptibly();                        
                    }
                    
                }
                finally{
                    l.unlock();
                }
            }
        }    
    }
}