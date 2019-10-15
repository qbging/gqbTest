package test.base;

public class VolatileTest1 {
	public static int count = 0;

	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					for (int j = 0; j < 100; j++) {
						count += 3;
//					}
					
				}
			}).start();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(count);
					
				}
			}).start();
//		}
//		System.out.println(count);
	}
}
