package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 创建线程的第四种方式：使用线程池
*
* */
public class ThreadPool {
    public static void main(String[] args) {
        // 创建一个大小为10的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 设置线程池的属性

        service.execute(new NumberThread()); // 适合适用于Runnable
//        service.submit();  // 适合适用于Callable

        // 关闭线程池
        service.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            } else {
                break;
            }
        }
    }
}
