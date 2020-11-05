package morethread;
/*
* 创建多线程的方式二：实现Runnable接口
* 1. 创建一个实现了Runnable接口的类
* 2. 实现run方法
* 3. 创建实现类的对象
* 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
* 5. 通过Thread类的对象调用start()方法
* */
public class ThreadTest2 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.setName("线程1");
        t1.start();

        // 启动第二个线程
        Thread t2 = new Thread(mThread);
        t2.setName("线程二");
        t2.start();
    }
}
class MThread implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i < 100; i++){
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

