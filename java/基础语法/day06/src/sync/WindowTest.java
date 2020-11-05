package sync;

/*
* 三个窗口卖票，总票数100张
* 实现Runnable接口
* 线程安全问题
* 同步机制，解决线程安全问题
* 方式一：同步代码块
* synchronized(同步监视器){
*   // 需要被同步的代码
* }
* */
public class WindowTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        t1.setName("线程一：");
        Thread t2 = new Thread(window);
        t2.setName("线程二：");
        Thread t3 = new Thread(window);
        t3.setName("线程三：");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Window implements Runnable{
    private int ticket = 100;
    private Object obj = new Object();
    @Override
    public void run() {
        while(true){
//            synchronized (obj){
            synchronized (this){ // 也可以使用this充当锁
                if(ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "：已出售：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}
