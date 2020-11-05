package morethread;

/*
* 1. start() 启动当前线程，调用当前线程的run()
* 2. run() 通常需要重写Thread类中的方法，将创建的线程要执行的操作声明在此方法中
* 3. currentThread() 静态方法，返回当前代码执行的线程
* 4. getName() 获取当前线程的名字
* 5. setName() 设置当前线程的名字
* 6. yield() 释放当前CPU的所有权
* 7. join() 在线程A中调用线程B的join(),此时的线程A进入阻塞状态，直到线程B执行完毕
* 8. sleep(long millis) 阻塞当前线程millis毫秒
* 9. isAlive() 判断当前线程是否存活
* */
public class ThreadMethodTest {
    public static void main(String[] args){
        ThreadMethod tm = new ThreadMethod();
        tm.setName("线程1");
        tm.setPriority(Thread.MAX_PRIORITY);
        tm.start();
        for(int i = 1; i <= 100; i++){
            System.out.println("主线程: " + i);
            if(i == 20) {
                try {
                    tm.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class ThreadMethod extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "优先级：" + Thread.currentThread().getPriority());
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
            if(i % 2 == 0) {
                yield();
            }
        }
    }
}
