package test.thread.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class thr implements Runnable{
	private int index;
	public thr(int i) {
		this.index = i;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(index);
		
	}
}
public class Theadtest {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		thr t1 = new thr(1);
		thr t2 = new thr(2);
		thr t3 = new thr(3);
		thr t4 = new thr(4);
		thr t5 = new thr(5);
			
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
//		pool.shutdown();
//		while (true){
//			if (pool.isShutdown()) {
//				System.out.println("shutdown");
//			}
//			if(pool.isTerminated()){
//				System.out.println("isterminated");
//				break;
//			}
//			
//		}
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 5; i < 10; i++) {
			pool.execute(new thr(i));
		}
	}
}
