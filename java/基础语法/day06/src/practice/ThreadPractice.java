package practice;
/*
* 创建两个线程，其中一个打印100以内的偶数，另一个打印100以内的奇数
* */
public class ThreadPractice {
    public static void main(String[] args) {
        Practice p1 = new Practice();
        Practice p2 = new Practice(false);
        p1.start();
        p2.start();
    }
}

class Practice extends Thread{
    private boolean flag = true;
    public Practice(){}
    public Practice(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            if(flag && i % 2 == 0) {
                System.out.println("偶数：" + i);
            } else if(!flag && i % 2 != 0) {
                System.out.println("奇数：" + i);
            }
        }
    }
}
