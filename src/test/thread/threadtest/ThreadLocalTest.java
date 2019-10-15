package test.thread.threadtest;

/**
 * @author qifuguang
 * @date 15/9/2 00:05
 */
public class ThreadLocalTest {
    private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    static class MyThread implements Runnable {
    	private Integer num = 0;
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("线程" + index + "的初始value:" + value.get());
            System.out.println("线程" + index + "的初始num:" + num);
            for (int i = 0; i < 10; i++) {
            	num += i;
                value.set(value.get() + i);
            }
            System.out.println("线程" + index + "的累加value:" + value.get());
            System.out.println("线程" + index + "的累加num:" +num);
        }
    }
    
    public static void main(String[] args) {
    	for (int i = 0; i < 5; i++) {
    		new Thread(new MyThread(i)).start();
    	}
    }
}