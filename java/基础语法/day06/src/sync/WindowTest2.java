package sync;

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();


        t1.start();
        t2.start();
        t3.start();
    }
}
class Window2 extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
//            synchronized (obj) {
            synchronized (Window2.class) {
                // 也可以使用 类名.class 充当锁
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
