package practice;
/*
* 修复单例模式的线程安全问题
* */
public class BankTest {
    public static void main(String[] args) {

    }
}

class Bank{
    private Bank(){}
    private static Bank instance = null;
    public static synchronized Bank getInstance(){
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }
}
