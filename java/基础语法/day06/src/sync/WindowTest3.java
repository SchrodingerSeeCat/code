package sync;
/*
* 使用同步方法解决实现Runnable接口的线程安全问题
* */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();

        Thread wn1 = new Thread(window3);
        Thread wn2 = new Thread(window3);
        Thread wn3 = new Thread(window3);

        wn1.start();
        wn2.start();
        wn3.start();
    }
}

class Window3 implements Runnable{
    private int ticket = 100;
    @Override
    public void run(){
        while(true) {
            show();
        }
    }

    private synchronized void show() {
        if(ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：已出售：" + ticket);
            ticket--;
        }
    }
}
