package test.thread.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		LockTest test = new LockTest();
		final ReentrantLock lock = test.lock;
		final Condition condition = lock.newCondition();//保证多个线程使用同一个condition
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("t1开始");
					lock.lockInterruptibly();
					System.out.println("t1获得锁");
					Thread.sleep(3000);
					System.out.println("t1执行任务后调用await释放锁");
					condition.await();
					System.out.println("t1重新获得锁");
				} catch (InterruptedException e) {
					System.out.println("t1异常");
				} finally{
					System.out.println("t1释放锁");
					lock.unlock();
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("t2开始");
					lock.lockInterruptibly();
					System.out.println("t2获得锁");
//					Thread.sleep(3000);
					System.out.println(condition.equals(lock.newCondition()));
					condition.signalAll();
					System.out.println("t2唤醒signalAll其他锁");
				} catch (InterruptedException e) {
					System.out.println("异常");
				}finally{
					System.out.println("t2释放锁");
					lock.unlock();
				}
				
			}
		}).start();
	}
}
