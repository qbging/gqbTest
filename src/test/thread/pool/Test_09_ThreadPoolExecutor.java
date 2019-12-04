/**
 * 线程池
 * 固定容量线程池
 */
package test.thread.pool;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 输出：
 * java.util.concurrent.ThreadPoolExecutor@135fbaa4[Running, pool size = 5, active threads = 5, queued tasks = 1, completed tasks = 0]
 * false
 * true
 * java.util.concurrent.ThreadPoolExecutor@135fbaa4[Shutting down, pool size = 5, active threads = 5, queued tasks = 1, completed tasks = 0]
 * pool-1-thread-1 - test executor
 * pool-1-thread-2 - test executor
 * pool-1-thread-3 - test executor
 * pool-1-thread-5 - test executor
 * pool-1-thread-4 - test executor
 * pool-1-thread-1 - test executor
 * true
 * true
 * java.util.concurrent.ThreadPoolExecutor@135fbaa4[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 6]
 */
public class Test_09_ThreadPoolExecutor {
	
	public static void main(String[] args) {
		// 模拟fixedThreadPool， 核心线程5个，最大容量5个，线程的生命周期无限。
		ExecutorService service = 
				new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, 
						new LinkedBlockingQueue<Runnable>());
		
		for(int i = 0; i < 6; i++){
			service.execute(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " - test executor");
				}
			});
		}
		
		System.out.println(service);
		
		service.shutdown();
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		service.shutdown();
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
	}

}
