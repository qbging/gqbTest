package test.thread;

/**
 * 线程状态 new runnable blocked wating terminated
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number=1L;
        while (true) {
            System.out.println("Thread status:"+getState());
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime",number);
                System.out.println();
            }
            if (isInterrupted()) {
                System.out.println("The Prime Generator has been Interrupted");
                System.out.println("Thread status:"+getState());
                return;
            }
            number++;
        }
    }
    private boolean isPrime(long number) {
        if (number <=2) {
            return true;
        }

        for (long i=2; i<number; i++){
            if ((number % i)==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread task=new PrimeGenerator();
        System.out.println("Thread status:"+task.getState());
        task.start();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
        System.out.println("Thread status:"+task.getState());
    }
}