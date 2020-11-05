package sync;

import java.util.concurrent.locks.ReentrantLock;

/*
* 解决线程安全问题的方式三：Lock锁
* */
public class LockTest {
    public static void main(String[] args) {
        Window5 wi = new Window5();

        Thread t1 = new Thread(wi);
        Thread t2 = new Thread(wi);
        Thread t3 = new Thread(wi);

        t1.start();
        t2.start();
        t3.start();
    }
}
class Window5 implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
           try{
               // 调用lock上锁
               lock.lock();
               if (ticket > 0) {
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + ": " + ticket);
                   ticket--;
               } else {
                   break;
               }
           } finally {
               // 解锁
               lock.unlock();
           }
        }
    }
}
