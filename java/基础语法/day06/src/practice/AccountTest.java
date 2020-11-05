package practice;

import java.util.concurrent.locks.ReentrantLock;

/*
* 银行有一个用户有两个储户向同一个账户存钱3000,每次村1000,存三次，每次存完打印账户余额
* */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();

        Thread user1 = new Thread(account);
        user1.setName("user1");
        Thread user2 = new Thread(account);
        user2.setName("user2");

        user1.start();
        user2.start();
    }
}

class Account implements Runnable{
    private int balance = 0;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        int i = 3;
        while (i-- > 0) {
            store(1000);
        }
    }
    private void store(int num){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try{
            balance = balance + num;
            System.out.println(Thread.currentThread().getName() + ": " + balance);
        } finally {
            lock.unlock();
        }
    }
}
