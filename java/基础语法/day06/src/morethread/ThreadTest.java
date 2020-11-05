package morethread;
/*
* 多线程的创建，方式一：继承于Thread类并重写
* */
public class ThreadTest {
    public static void main(String[] args){
        MyThread t1 = new MyThread();
        t1.start();
        for(int i = 1; i <= 100; i++){
            if(i % 2 != 0) {
                System.out.printf("MainThread: %d\n", i);
            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0) {
                System.out.printf("MyThread: %d\n", i);
            }
        }
    }
}