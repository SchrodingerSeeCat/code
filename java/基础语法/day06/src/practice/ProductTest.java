package practice;
/*
* 生产者消费者问题
*
* 生产者(Producer)将产品交给店员(Clerk),而消费者(Customer)从店员处取走产品，
* 店员一次只能持有固定数量的产品(比如：20)，如果生产者试图生产更多的产品，店员会
* 让生产者wait，如果店中有空位放产品了再通知生产者继续生产：如果店中没有产品了，店员
* 会告诉消费者等一下，等店中有产品了，再通知消费者来取走产品
*
* */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p = new Producer(clerk);
        p.setName("生产者");

        Customer c = new Customer(clerk);
        c.setName("消费者");

        p.start();
        c.start();
    }
}

class Clerk{
    private int product = 0;

    public int getProduct() {
        return product;
    }
    // 消费产品
    public synchronized void consume(){
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + product);
            product--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 生产产品
    public synchronized void produce(){
        if (product < 20) {
            System.out.println(Thread.currentThread().getName() + "开始生产第" + product);
            product++;

            // 唤醒消费者
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
       while (true) {
           clerk.produce();
       }
    }
}

class Customer extends Thread{
    private Clerk clerk;
    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true) {
            clerk.consume();
        }
    }
}
