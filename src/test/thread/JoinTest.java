package test.thread;

class ParentThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Parent is doing...");
        try {
            Thread t = new Thread(new ChildThread());
            t.start();
            t.join();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Parent had done.");
    }
}
class ChildThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Child is doing...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child had done.");
    }
}
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

        ParentThread p = new ParentThread();
        ChildThread c = new ChildThread();
        Thread tp = new Thread(p);
        Thread tc = new Thread(c);
        tp.start();
        tp.join();//此时，main会被阻塞，只到tp执行完，如果没有tp.join,main瞬间执行完
        tc.join();//没启动，无用
        System.out.println("main has done");
        /** with tp.join
         * Parent is doing...
         Child is doing...
         Child had done.
         Parent had done.
         main has done

         without tp.join
         main has done
         Parent is doing...
         Child is doing...
         Child had done.
         Disconnected from the target VM, address: 'javadebug', transport: 'shared memory'
         Parent had done.
         */
    }
}
