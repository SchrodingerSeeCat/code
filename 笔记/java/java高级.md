# java高级

[TOC]

## 1. 多线程

### 1.1 基本概念

1. 程序`program`：是为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态的代码，静态对象

2. 进程`process`：是程序的一次执行过程，或是正在运行的一个程序。是一个动态的过程：有它自身的产生、存在和消亡的过程。---生命周期，进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域。

3. 线程`thread`：进程可进一步细化为线程，是一个程序内部的一条执行路径

   - 若一个进城同一时间并行执行多个线程，就是支持多线程的

   - 线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器(pc),线程切换的开销比较小
   - 一个进程中的多个线程共享相同的内存单元/内存地址空间->它们从同一堆中分配对象，可以访问相同的变量和对象。这就使得线程间通信更简便、高效。但多个线程操作共享的系统资源就可能会带来安全的隐患

4. 并行与并发

   并行：多个CPU同时执行多个任务

   并发：一个CPU(采用时间片)同时执行多个任务

### 1.2 线程的创建和使用

#### 1.2.1 方式一

1. 创建一个继承于`Thread`类的子类

2. 重写`Thread`类的`run()`，将此线程执行的操作声明在`run()`中

3. 创建`Thread`类的子类的对象

4. 通过此对象调用`start()`：`start`会启动这个线程，调用当前线程的`run()`

   ```java
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
   ```

   执行结果

   ```java
   MainThread: 1
   MainThread: 3
   MainThread: 5
   MainThread: 7
   MainThread: 9
   MainThread: 11
   MainThread: 13
   MainThread: 15
   MainThread: 17
   MainThread: 19
   MainThread: 21
   MainThread: 23
   MainThread: 25
   MainThread: 27
   MainThread: 29
   MainThread: 31
   MainThread: 33
   MainThread: 35
   MainThread: 37
   MainThread: 39
   MainThread: 41
   MainThread: 43
   MyThread: 2
   MyThread: 4
   MainThread: 45
   MainThread: 47
   MainThread: 49
   MainThread: 51
   MainThread: 53
   MainThread: 55
   MainThread: 57
   MainThread: 59
   MainThread: 61
   MainThread: 63
   MainThread: 65
   MainThread: 67
   MainThread: 69
   MainThread: 71
   MainThread: 73
   MyThread: 6
   MyThread: 8
   MyThread: 10
   MainThread: 75
   MainThread: 77
   MainThread: 79
   MainThread: 81
   MainThread: 83
   MainThread: 85
   MainThread: 87
   MainThread: 89
   MainThread: 91
   MainThread: 93
   MainThread: 95
   MainThread: 97
   MainThread: 99
   MyThread: 12
   MyThread: 14
   MyThread: 16
   MyThread: 18
   MyThread: 20
   MyThread: 22
   MyThread: 24
   MyThread: 26
   MyThread: 28
   MyThread: 30
   MyThread: 32
   MyThread: 34
   MyThread: 36
   MyThread: 38
   MyThread: 40
   MyThread: 42
   MyThread: 44
   MyThread: 46
   MyThread: 48
   MyThread: 50
   MyThread: 52
   MyThread: 54
   MyThread: 56
   MyThread: 58
   MyThread: 60
   MyThread: 62
   MyThread: 64
   MyThread: 66
   MyThread: 68
   MyThread: 70
   MyThread: 72
   MyThread: 74
   MyThread: 76
   MyThread: 78
   MyThread: 80
   MyThread: 82
   MyThread: 84
   MyThread: 86
   MyThread: 88
   MyThread: 90
   MyThread: 92
   MyThread: 94
   MyThread: 96
   MyThread: 98
   MyThread: 100
   ```

5. `start()`一个对象只能调用一次

6. `Thread`中常用的方法

   ```java
   start() 启动当前线程，调用当前线程的run()
   run() 通常需要重写Thread类中的方法，将创建的线程要执行的操作声明在此方法中
   currentThread() 静态方法，返回当前代码执行的线程
   getName() 获取当前线程的名字
   setName() 设置当前线程的名字
   yield() 释放当前CPU的所有权
   join() 在线程A中调用线程B的join(),此时的线程A进入阻塞状态，直到线程B执行完毕
   sleep(long millis) 阻塞当前线程millis毫秒
   isAlive() 判断当前线程是否存活
   ```

#### 1.2.2 方式二

1. 创建一个实现了Runnable接口的类

2. 实现run方法

3. 创建实现类的对象

4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象

5. 通过Thread类的对象调用start()方法

   ```java
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
   ```

6. 比较创建线程的两种方式

   开发中优先使用Runnable接口的方式

   实现的方式没有类的单继承性的局限性

   实现的方式更适合来处理多个线程有共享数据的情况

#### 1.2.3 方式三

**实现Callable接口与使用`Runnable`相比，`Callable`功能更强大些**

1. 相比`run()`方法，可以有返回值
2. 方法可以抛出异常
3. 支持泛型的返回值
4. 需要借助`Future Task`类，比如获取返回结果

**`Future`接口**

1. 可以对具体`Runnable`、`Callable`任务的执行结果进行取消、查询是否完成、获取结果等。
2. `FutureTask`是`Futrue`接口的唯一实现类
3. `FutureTask`同时实现了`Runnable`、`Future`接口。它既可以作为`Runnable`被线程执行，又可以作为`future`得到`Callable`的返回值。

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) {
        // 创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        // 将此CallAble接口实现类的对象作为传递到FutureTask(numThread);
        FutureTask futureTask = new FutureTask(numThread);

        // 将FutureTask的对象作为参数传递到Thread传递到Thread类的构造器中，创建Thread对象，并调用start
        new Thread(futureTask).start();
        try {
            // get()返回值即为FutureTask构造器参数Callable实现类中重写的call方法的返回值
            Object num = futureTask.get();
            System.out.println("总和为：" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable{
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
```

**Callable与Runnable接口对比**

1. `call()`可以有返回值
2. `call()`可以抛出异常，被外面的操作捕获，获取异常信息
3. `Callable`可以支持实现泛型

#### 1.2.4 方式四

线程池：提前创建好多个线程，放入线程池中，使用时直接获取，使用完后放回池中。可以避免频繁创建销毁、实现重复利用。

**线程池API**

`JDK5.0`起提供了线程池相关API`ExecutorService`和`Executors`

- `ExecutorService`：真正的线程池接口。常见子类`ThreadPoolExecutor`
- `void execute(Runnable command)`：执行任务/命令，没有返回值，一般用来执行`Runnable`
- `<E> Future<E> submit(Callable<T> task)`：执行任务，有返回值，一般用来执行`Callable`
- `void shutdown()`：关闭连接池

`Executors`：工具类、线程池的工厂类，用于创建并返回不同类型的线程池

- `Executors.newCachedThreadPool()`：创建一个可根据需要创建新线程的线程池
- `Executors.newFixedThreadPool(n)`：创建一个可重用固定线程数的线程池
- `Executors.newSingleThreadExector()`：创建一个只有一个线程的线程池
- `Executors.newScheduledPool(n)`：创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行

线程管理

```java
corePoolSize：核心池的大小
maximumPoolSize：最大线程数
keepAliveTime：线程没有任务时最多保持的时间
```

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        // 创建一个大小为10的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

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
            }
        }
    }
}
```


#### 1.2.5 线程的调度

**调度策略**

- 时间片
- 抢占式：高优先级的线程抢占CPU

**java的调度方法**

- 同优先级线程组成先进先出(先到先服务)，使用时间片策略
- 对高优先级，使用优先调度的抢占式策略

**线程的优先级**

1. 线程的优先级等级

   ```java
   MAX_PRIORITY: 10
   MIN_PRIORITY: 1
   NORM_PRIORITY: 5 // 默认优先级
   ```

2. 涉及的方法

   ```
   // 返回线程的优先级
   getPriority();
   
   // 改变线程的优先级
   setPriority(int new Priority);
   ```

3. 说明

   线程创建时继承父线程的优先级

   低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用

### 1.3 线程的生命周期

 `JDK`中用`Thread.State`类定义了线程的几种状态，要想实现多线程，必须在主线程中创建新的线程对象。`Java`语言使用`Thread`类及其子类的对象来表示线程，在它的一个完整的生命周期中通常要经历如下的五种状态

- 新建：当一个`Thread`类或其子类的对象被声明并创建时，新生的线程对象处于新建状态
- 就绪：处于新建状态的线程被`start()`后，将进入线程队列等待CPU时间片，此时它已具备了运行的条件，只是没有分配到CPU资源
- 当就绪的线程被调度并获得CPU资源时，便进入运行状态，run()方法定义了线程的操作和功能
- 阻塞：在某种特殊情况下，被人为挂起或执行输入输出操作时，让出CPU并临时中止自己的执行，进入阻塞状态
- 死亡：线程完成了它的全部工作或线程被提前强制性地中止或出现异常导致结束

```mermaid
graph LR
新建 --> |调用start| 就绪
就绪 --> |获取CPU执行权| 运行
运行 --> |失去CPU执行权| 就绪
运行 --> |执行完run,调用stop,出现异常没有处理| 死亡
运行 --> |sleep,join,等待同步锁,wait,suspend| 阻塞
阻塞 --> |sleep结束,join结束,获取同步锁,notify,notifyAll,resume| 就绪
```

### 1.4 线程同步

多线程的问题：多个线程执行的不确定性引起执行结果的不稳定。多个线程对于数据的共享，会造成操作的不完整性，会破坏数据。

#### 1.4.1 方式一：同步代码块

```java
synchronized (同步监视器){
	// 需要被同步的代码 
}
```

- 操作共享数据的代码，即为需要被同步的代码

- 共享数据：多个线程共同操作的变量

- 同步监视器：锁，任何一个类的对象都可以充当锁,多个线程必须要共用同一把锁

  ```java
  public class WindowTest {
      public static void main(String[] args) {
          Window window = new Window();
  
          Thread t1 = new Thread(window);
          t1.setName("线程一：");
          Thread t2 = new Thread(window);
          t2.setName("线程二：");
          Thread t3 = new Thread(window);
          t3.setName("线程三：");
  
          t1.start();
          t2.start();
          t3.start();
      }
  }
  class Window implements Runnable{
      private int ticket = 100;
      private Object obj = new Object();
      @Override
      public void run() {
          while(true){
              synchronized (obj){
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
  ```

- 同步的方式，解决了线程安全问题

- 在实现`Runnable`接口创建的多线程方式中，可以使用`this`充当同步监视器

- 在继承`Thread`类创建多线程的方式中，可以考虑使用当前类充当同步监视器

#### 1.4.2 方式二：同步方法

   如果操作共享数据的代码完整的声明在一个方法中，可以考虑将此方法声明同步的

`Runnable`

```java
class Window implements Runnable{
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
```

`Thread`

```java
class Window extends Thread{
    private static int ticket = 100;
    @Override
    public void run(){
        while(true) {
            show();
        }
    }
	
    // 必须保证同步的方法是静态的
    private static synchronized void show() {
        if(ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "：已出售：" + ticket);
            ticket--;
        }
    }
}
```

同步方法仍然涉及到同步监视器，只是不需要我们显示的声明

非静态的同步方法的同步监视器：`this`，静态的同步方法的同步监视器：当前类本身

#### 1.4.3 死锁

1. 死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁

2. 出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续

3. 使用同步时要避免出现死锁

   ```java
   public class ThreadTest {
       public static void main(String[] args) {
           StringBuffer s1 = new StringBuffer();
           StringBuffer s2 = new StringBuffer();
   
           new Thread(){
               @Override
               public void run() {
                   synchronized (s1){
                       s1.append("a");
                       s2.append("1");
   
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
   
                       synchronized (s2) {
                           s1.append("b");
                           s2.append("2");
   
                           System.out.println(s1);
                           System.out.println(s2);
                       }
                   }
               }
           }.start();
   
           new Thread(new Runnable() {
               @Override
               public void run() {
                   synchronized (s2){
                       s1.append("3");
                       s2.append("c");
   
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
   
                       synchronized (s1) {
                           s1.append("d");
                           s2.append("4");
   
                           System.out.println(s1);
                           System.out.println(s2);
                       }
                   }
               }
           }).start();
       }
   }
   ```

#### 1.4.4 方式三：Lock(锁)

1. 从`JDK5.0`之后，`java`提供了更强大的线程同步机制——通过显示定义同步锁对象来实现同步。同步锁使用`Lock`对象充当

2. `java.util.concurrent.locks.Lock`接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对`Lock`对象加锁，线程开始访问共享资源之前应先获得`Lock`对象

3. `ReentrantLock`类实现了`Lock`，它拥有与`synchronized`相同的并发性和内存语义，在实现线程安全的控制中，比较常用的`ReentrantLock`，可以显示加锁、释放锁

   ```java
   import java.util.concurrent.locks.ReentrantLock;
   public class LockTest {
       public static void main(String[] args) {
           Window wi = new Window();
   
           Thread t1 = new Thread(wi);
           Thread t2 = new Thread(wi);
           Thread t3 = new Thread(wi);
   
           t1.start();
           t2.start();
           t3.start();
       }
   }
   class Window implements Runnable{
       private int ticket = 100;
       private ReentrantLock lock = new ReentrantLock();
       @Override
       public void run() {
           while (true) {
              try{
                  // 调用lock上锁
                  lock.lock();
                  if (ticket > 0) {
                      try {
                          Thread.sleep(10);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println(Thread.currentThread().getName() + ": " + ticket);
                      ticket--;
                  } else {
                      break;
                  }
              } finally {
                  // 解锁
                  lock.unlock();
              }
           }
       }
   }
   ```

4. `synchronized`与`Lock`的对比

   - `Lock`是显式锁(手动开启和关闭锁)，`synchronized`是隐式锁，出了作用域自动释放

   - `Lock`只有代码块锁，`synchronized`有代码块锁和方法锁

   - 使用`Lock`锁，`JVM`将花费较少的时间来调整线程，性能更好。并且具有更好的扩展性

### 1.5 线程通信

#### 1.5.1 涉及到的三个方法

- `wait() `：当前线程就进入阻塞状态，并释放同步监视器
- `notify()`：就会唤醒被`wait`的一个线程，如果有多个线程被`wait`，唤醒优先级高的线程
- `notifyAll`：唤醒所有被`wait`的线程
- 三个方法必须使用在同步代码块或同步方法中
- 三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则，会出现`IllgealMonitorStateException`异常
- 三个方法都定义在`Object`中

#### 1.5.2 线程通信的例子

使用两个线程打印 1-100 线程1 线程2 交替打印

```java
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                // 唤醒其他线程
                notify();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(number < 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                } else{
                    break;
                }

                try {
                    // 使得调用如下wait()方法的线程进入阻塞状态
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

#### 1.5.3 sleep和wait的异同

1. 相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态

2. 不同点：

   两个方法声明的位置不同：`Thread`类中声明`sleep()`，`Object`类中生命`wait()`。

   调用的要求不同：`sleep()`可以在任何需要的场景下调用，`wait()`必须使用在同步代码块中。

   关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，`sleep`不会释放同步监视器

## 2. JAVA常用类

### 2.1 字符串相关类

#### 2.1.1 String类

- `String`类代表字符串。`java`程序中的所有字符串字面值(如`abc`)都作为此类的实例出现

- `String`是一个`final`类，代表**不可变**的字符序列

- 字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改

- `String`对象的字符内容是存储在一个字符数组`value[]`中的

- `String`实现了`Serializable`接口：表示字符串是支持序列化的；实现了`Comparable`接口，可比较大小

- 通过字面量的方式(区别于new)给一个字符串赋值，此时的字符串声明在字符串常量池中。常量池中不会维护两个相同的字符串常量

  ```java
  public static void main(String[] args) {
  	String str1 = "abc";
      String str2 = "abc";
      System.out.println(str1 == str2); // true
      str2 = "hello";
      System.out.println(str1 == str2); // false
  }
  ```
  

**String对象的创建**

对于`new`的字符串声明在堆中，堆中的变量引用常量池中的字符串，普通字面量赋值声明在常量池中

```java
public static void test2(){
    String str1 = "hello";
    String str2 = new String("hello");
    System.out.println(str1 == str2); // false
}
```

**String不同的拼接方式**

常量与常量的拼接结果在常量池中。且常量池中不会存在相同内容的常量

```java
public static void test3(){
    String s1 = "hello";
    String s2 = "world";

    String s3 = "helloworld";
    String s4 = "hello" + "world";
    String s5 = s1 + "world";
    String s6 = "hello" + s2;
    String s7 = s1 + s2;

    System.out.println(s3 == s4); // true
    System.out.println(s3 == s5); // false
    System.out.println(s3 == s6); // false
    System.out.println(s3 == s7); // false
    System.out.println(s5 == s6); // false
    System.out.println(s5 == s7); // false
    System.out.println(s6 == s7); // false
}
```

![image-20201105165311825](./java高级.assets/image-20201105165311825.png)

返回值得到的s8使用常量池中已经存在的"helloworld"

```java
String s8 = s5.intern();
System.out.println(s3 == s8); //true
```

**String常用方法**

- 返回字符串长度`int length()`

  ```java
  public static void main(String[] args){
  	String str = "Hello ";
      String str2 = "world";
      String str3 = "hello ";
  	System.out.println(str.length()); // 6
  }
  ```

- 返回指定索引处的字符`char charAt(int index)`

  ```java
  System.out.println(str.charAt(1)); // e
  ```

- 判断是否是空字符串`boolean isEmpty()`

  ```java
  System.out.println(str.isEmpty()); // false
  ```

- 使用默认语言环境，将`String`中的所有字符转换为小写`String toLowerCase()`

  ```java
  System.out.println(str.toLowerCase()); // hello
  ```

- 使用默认语言环境，将`String`中所有的字符转换为大写`String toUpperCase()`

  ```java
  System.out.println(str.toUpperCase()); // HELLO
  ```

- 返回字符串的副本，忽略前导空白和尾部空白`String trim()`

  ```java
  System.out.println(str.trim()); // hello
  ```

- 比较字符串的内容是否相同`boolean equals(Object obj)`

  ```java
  System.out.println(str.equals(str2)); // false
  ```

- 与`equals`方法类似，忽略大小写`boolean equalsIgnoreCase(String anotherString)`

  ```java
  System.out.println(str.equalsIgnoreCase(str3)); // true
  ```

- 将指定字符连接到此字符串的结尾。等价于"+"`String concat(String str)`

  ```java
  System.out.println(str.concat(str2)); // Hello world
  ```

- 比较两个字符串的大小`int compareTo(String anotherString)`

  ```java
  System.out.println(str.compareTo(str2)); // -47
  ```

- 返回一个新的字符串，它是此字符串从`beginIndex`开始截取的子串`String substring(int beginIndex)`

  ```java
  System.out.println(str.substring(2)); // llo 
  ```

- 返回一个新的字符串，它是此字符串从`beginIndex`开始到`endIndex`(不包括)结束`String substring(int beginIndex, int endIndex)`

  ```java
  System.out.println(str.substring(1, 3)); // el
  ```

- 判断此字符串是不是以指定字符串结束`boolean endsWith(String suffix)`

  ```java
  System.out.println(str.endsWith(" ")); // true
  ```

- 判断此字符串是不是以指定字符串开始`boolean startsWith(String prefix)`

  ```java
  System.out.println(str.startsWith("He")); // true
  ```
  
- 判断字符串是否包含另外一个字符串`boolean contains(String str)`

  ```java
  System.out.println(str.startsWith("He")); // true
  ```

**String和其它结构的转换**

1. 与包装类的转换

   `String` --> 基本数据类型，包装类：调用`parseXxx(str)`

   ```java
   @Test
   public void test1() {
       String str = "123";
       int num = Integer.parseInt(str);
       System.out.println(num);
   }
   ```

   基本数据类型 --> `String`

   ```java
   @Test
   public void test2(){
       // 基本数据类型转String
       int num = 123;
       String str1 = String.valueOf(num);
       String str2 = num + "";
   
       System.out.println(str1);
       System.out.println(str2);
   }                                                                
   ```

2. 与`char[]`之间的转换

   `String` --> `char[]`

   ```java
   @Test
   public void test3(){
       String str1 = "abc123";
       char[] charArray = str1.toCharArray();
       for(int i = 0; i < charArray.length; i++){
       System.out.print(charArray[i]);
       }
   }
   ```

   `char[]` --> `String`

   ```java
   @Test
   public void test4(){
       char[] charArray = {'1', 'a', 'c'};
       String str = new String(charArray);
       System.out.println(str);
   }
   ```

3. 与`byte[]`之间的转换

   `String` --> `byte[]`

   ```java
   @Test
   public void test5(){
       String str = "abc123";
       byte[] bytes = str.getBytes();
       System.out.println(Arrays.toString(bytes));
   }
   ```

   `byte[]` --> `String`

   ```java
   @Test
   public void test6(){
       byte[] bytes = {97, 98, 99, 49, 50, 51};
       String str = new String(bytes);
       System.out.println(str);
   }
   ```

#### 2.1.2 StringBuffer 和 StringBuilder

**三者的异同**

1. `StringBuffer`与`StringBuilder`都是可变的字符序列，`String`是不可变的字符序列
2. `StringBuffer`是线程安全的：效率低
3. `StringBuilder`：线程不安全，效率高
4. 底层都是使用`char[]`存储
5. `StringBuffer`和`StringBuilder`默认容量为`16`，对于扩容，会扩容为原来容量的`2倍加2`

**常用方法StringBuffer和StringBuilder相同**

```java
public static void main(String[] args) {
	StringBuffer str = new StringBuffer();
}
```

- 字符串的拼接`StringBuffer append(xxx)`

  ```java
  str.append("a");
  str.append(1);
  System.out.println(str); // Helloa1
  ```

- 删除指定位置的内容`StringBuffer delete(int start, int end)`

  ```java
  str.delete(4, 5);
  System.out.println(str); // Hell
  ```

- 替换字符串`StringBuffer replace(int start, int end, String str)`

  ```java
  str.replace(2, 4, "qwe");
  System.out.println(str); // heqweo
  ```

- 在指定位置插入`StringBuffer insert(int offset, xxx)`

  ```java
  str.insert(1, 123);
  System.out.println(str); // H123ello
  ```

- 反转当前字符序列`StringBuffer reverse()`

  ```java
  str.reverse();
  System.out.println(str); // olleH
  ```

- 设置某索引位置的字符`void setCharAt(int n, char ch)`

  ```java
  str.setCharAt(2, 't');
  System.out.println(str); // Hetlo
  ```

### 2.2 日期和时间

#### 2.2.1 JDK8之前

1. `java.lang.System`类

   `System`类提供的`public static long currentTimeMillis()`用来返回当前时间与`1970年1月1日0时0分0秒`之间的毫秒时间差(时间戳)

   ```java
   @Test
   public void test(){
       long time = System.currentTimeMillis();
       System.out.println(time); // 1604722875525
   }
   ```

2. `Date`类

   `java.util.Date`类

   ```java
   @Test
   public void test(){
       Date date = new Date();
       System.out.println(date); // Sat Nov 07 12:26:19 CST 2020
       System.out.println(date.getTime()); // 1604723179115 时间戳
   }
   ```

   自己构造时间对象

   ```java
   @Test
   public void test(){
       Date date = new Date(1604723179115L);
       System.out.println(date); // Sat Nov 07 12:26:19 CST 2020
   }@Test
   public void test7(){
       Calendar calendar = Calendar.getInstance();
       int day = calendar.get(Calendar.DAY_OF_MONTH);
       System.out.println("这个月的第 " + day + " 天"); // 这个月的第 7 天
   
       calendar.set(Calendar.DAY_OF_MONTH, 22);
       day = calendar.get(Calendar.DAY_OF_MONTH);
       System.out.println("今天更改为 " + day + " 天"); // 今天更改为 22 天
   
       calendar.add(Calendar.DAY_OF_MONTH, 3); // 可以为负
       day = calendar.get(Calendar.DAY_OF_MONTH);
       System.out.println("今天加 " + day + " 天"); // 今天加 25 天
   
       Date date = calendar.getTime(); // 获取时间对象
       System.out.println(date); // Wed Nov 25 16:07:04 CST 2020
   
       Date date1 = new Date();
       calendar.setTime(date1);
   }
   ```

   `java.sql.Date`类是`java.util.Date`的子类，对应数据库中的日期

   ```java
    @Test
    public void test(){
        java.sql.Date date = new java.sql.Date(1604723409503L);
        System.out.println(date); // 2020-11-07
    }
   ```

   `util.Date` --> `sql.Date`

   ```java
   @Test
   public void test(){
       java.util.Date date = new java.util.Date();
       java.sql.Date date2 = new java.sql.Date(date.getTime());   
   }
   ```

3. `java.text.SimpleDateFormat`类

   使用默认的构造器，即使用默认的时间格式

   ```java
   @Test
   public void test(){
       SimpleDateFormat sdf = new SimpleDateFormat();
   
       // 格式化
       Date date = new Date();
       String format = sdf.format(date);
       System.out.println(format); // 11/7/20, 3:21 PM
       
       // 解析
       String str = "11/7/20, 3:21 PM";
       try {
           Date date1 = sdf.parse(str);
           System.out.println(date1); // Sat Nov 07 15:21:00 CST 2020
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }
   ```

   使用自定义的时间格式

   ```java
   @Test
   public void test(){
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       
       // 格式化
       String format = sdf.format(new Date());
       System.out.println(format); // 2020-11-07 03:29:49
       
       // 解析
       try {
           Date date = sdf.parse("2020-11-07 03:29:49");
           System.out.println(date); // Sat Nov 07 03:29:49 CST 2020
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }
   ```

4. `java.util.Calendar`日历类

   `Calendar`是一个抽象基类，主要用于完成日期字段之间的相互操作的功能

   获取`Calendar`实例的方法：使用`Calendar.getInstance()`方法，调用它的子类`GregorianCalendar`的构造器

   ```java
   @Test
   public void test7(){
       Calendar calendar = Calendar.getInstance();
       int day = calendar.get(Calendar.DAY_OF_MONTH);
       System.out.println("这个月的第 " + day + " 天"); // 这个月的第 7 天
   
       calendar.set(Calendar.DAY_OF_MONTH, 22);
       day = calendar.get(Calendar.DAY_OF_MONTH);
       System.out.println("今天更改为 " + day + " 天"); // 今天更改为 22 天
   
       calendar.add(Calendar.DAY_OF_MONTH, 3); // 可以为负
       day = calendar.get(Calendar.DAY_OF_MONTH);
       System.out.println("今天加 " + day + " 天"); // 今天加 25 天
   
       Date date = calendar.getTime(); // 获取时间对象
       System.out.println(date); // Wed Nov 25 16:07:04 CST 2020
   
       Date date1 = new Date();
       calendar.setTime(date1); // 重新设置日期
   }
   ```

#### 2.2.2 JDK8的日期时间

- `java.time`：包含值对象的基础包
- `java.time.chrono`：提供对不同的日历系统的访问
- `java.time.format`：格式化和解析时间和日期
- `java.time.temporal`：包括底层框架和扩展特性
- `java.time.zone`：包含时区支持的类

对于绝大多数的开发者来说通常只能用到`java.time`和`java.time.format`

1. `LocalDate`、 `LocalTime`、 `LocalDateTime`

   ```java
   @Test
   public void test1(){
       LocalDate localDate = LocalDate.now();
       LocalTime localTime = LocalTime.now();
       LocalDateTime localDateTime = LocalDateTime.now();
   
       System.out.println(localDate); // 2020-11-07
       System.out.println(localTime); // 16:27:27.916185
       System.out.println(localDateTime); // 2020-11-07T16:27:27.916208
   }
   ```

   **`of() `设置指定的年，月，日，时，分，秒。没有偏移量**

   ```java
   LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 7, 16, 30);
   System.out.println(localDateTime); // 2020-11-07T16:30
   ```

   **getXxx 获取年，月，日，时，分，秒**

   ```java
   LocalDateTime localDateTime = LocalDateTime.now();
   System.out.println(localDateTime.getDayOfMonth()); // 7
   
   System.out.println(localDateTime1.getMonth()); // NOVEMBER
   System.out.println(localDateTime1.getMonthValue()); // 11
   ```

   **withXxx设置日期时间**

   ```java
   LocalDateTime localDateTime = LocalDateTime.now();
   LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(22);
   System.out.println(localDateTime1); // 2020-11-22T16:30
   ```

   **plusXxx添加指定的日期时间, minusXxx减去指定的时间日期**

   ```java
   LocalDateTime localDateTime = LocalDateTime.now();
   System.out.println(localDateTime); // 2020-11-07T16:44:09.883564
   LocalDateTime localDateTime1 =  localDateTime.plusDays(3);
   System.out.println(localDateTime1); // 2020-11-10T16:44:09.883564
   ```

2. 瞬时 `instant`

   `instant`：时间线上的一个瞬时点。这可能被用来记录应用程序中的时间时间戳

   ```java
   @Test
   public void test(){
       Instant instant = Instant.now(); // 获取的是本初子午线的时间
       System.out.println(instant); // 2020-11-07T08:50:44.950285Z
       
       OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
       System.out.println(offsetDateTime); // 2020-11-07T16:54:37.527700+08:00 东八区时间
       
       // 获取对应的时间戳
       long l = instant.toEpochMilli();
       System.out.println(l); // 1604739444190
       
       // 解析
       Instant instant1 = Instant.ofEpochMilli(1604739444190L);
       System.out.println(instant1); // 2020-11-07T08:57:24.190Z
   }
   ```

3. `java.time.format.DateTimeFormatter`类，用来格式化或解析日期、时间，类似于`SimpleDateFormat`

   预定义的标准格式：`ISO_LOCAL_DATE_TIME`，`ISO_LOCAL_DATE`，`ISO_LOCAL_TIME`

   预定义方式

   ```java
   @Test
   public void test(){
       DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
       // 格式化
       LocalDateTime localDateTime = LocalDateTime.now();
       String str = formatter.format(localDateTime);
       System.out.println(localDateTime); // 2020-11-07T19:33:55.475751
       System.out.println(str); // 2020-11-07T19:33:55.475751
       
       // 解析
       TemporalAccessor parse = formatter.parse("2020-11-07T19:33:55.475751");
       System.out.println(parse); // {},ISO resolved to 2020-11-07T19:33:55.475751
   }
   ```

   本地方式`ofLocalizedDateTime()/ofLocalizedDate`，`FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT`：适用于`LocalDateTime`

   ```java
   @Test
   public void test(){
       // 本地化相关的格式
       LocalDateTime localDateTime = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
       String str = formatter.format(localDateTime);
       System.out.println(str); // 11/7/20, 7:52 PM
   }
   ```

   自定义方式`ofPattern("yyyy-MM-dd hh:mm:ss")`

   ```java
   @Test
   public void test(){
       // 自定义相关的格式
       LocalDateTime localDateTime = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
       String str = formatter.format(localDateTime);
       System.out.println(str); // 2020-11-07 08:03:00
       
       // 解析
       TemporalAccessor date =  formatter.parse("2020-11-07 08:03:00");
       System.out.println(date);
       // {NanoOfSecond=0, SecondOfMinute=0, MilliOfSecond=0, HourOfAmPm=8, MinuteOfHour=3, MicroOfSecond=0},ISO resolved to 2020-11-07
   }
   ```

4. 其它API

   - `Zoneld`：该类中包含了所有的时区信息，一个时区的`ID`，如`Europe/Paris`
- `ZonedDateTime`：一个在`ISO-8601`日历系统时区的日期时间，如`2007-12-03T10:15:30+01:00 Europe/Pairs`其中每个时区都对应着`ID`，地区`ID`都为{区域}/{城市}的格式 `Asia/Shanghai`
   - `Clock`：使用时区提供对当前即时、日期和时间的访问时钟
- 持续时间：`Duration`，用于计算两个"时间"间隔
   - 日期间隔：`Period`，用于计算两个"日期"间隔
- `TemporalAdjuster`：时间校正器。有时我们可能需要获取例如：将日期调整到"下一个工作日"等操作
   - `TemporalAdjusters`：该类通过静态方法`firstDayOfXxx()/lastDayOfXxx/nextXxx()`提供了大量的常用`TemporalAdjuster`的实现

### 2.3 java比较器

`java`实现对象排序的方式有两种：自然排序`java.lang.Comparable`，定制排序`java.util.Comparator`

#### 2.3.1 Comparable的使用

1. 像`String`、包装类等实现了`Comparable`接口，重写了`compareTo`方法，给出了比较两个对象大小的方式

2. `String`、包装类重写了`compareTo()`方法以后，进行了从小到大的排序

3. 重写`compareTo()`的规则

   如果当前对象`this`大于形参对象`obj`，则返回正整数

   如果当前对象`this`小于形参对象`obj`，则返回负整数

   如果当前对象`this`等于形参对象`obj`，则返回零

4. 对于自定义的类，如果需要排序，我们可以让自定义类实现`Comparable`接口，重写`compareTo(obj)`方法在`compareTo(obj)`方法中指名如何排序

   ```java
   package compare;
   
   import org.junit.Test;
   
   import java.util.Arrays;
   public class CompareTest {
       @Test
       public void test(){
           Goods[] arr = new Goods[4];
           arr[0] = new Goods("小米", 99.9);
           arr[1] = new Goods("雷蛇", 299.9);
           arr[2] = new Goods("HP", 19.9);
           arr[3] = new Goods("戴尔", 199.9);
           Arrays.sort(arr);
           System.out.println(Arrays.toString(arr));
           // [Goods{name='HP', price=19.9}, Goods{name='小米', price=99.9}, Goods{name='戴尔', price=199.9}, Goods{name='雷蛇', price=299.9}]
       }
   
   }
   
   class Goods implements Comparable{
       private String name;
       private double price;
       public Goods(String name, double price){
           this.name = name;
           this.price = price;
       }
       @Override
       public String toString() {
           return "Goods{" +
                   "name='" + name + '\'' +
                   ", price=" + price +
                   '}';
       }
   
       @Override
   	public int compareTo(Object o) {
           if (o instanceof Goods) {
               Goods goods = (Goods)o;
               return (int)(this.price - goods.price);
           }
           throw new ClassCastException("类型错误");
       }
   }
   ```

#### 2.3.2 定制排序 Comparator

1. 当元素的类型没有实现`java.lang.Comparable`接口而又不方便修改代码，或者实现了`java.lang.Comaprable`接口的顺序不适合当前的操作，那么可以考虑使用`Comparator`的对象来排序，强行对多个对象进行整体排序的比较

2. 重写`compare(Object o1, Object o2)`方法，比较`o1`和`o2`的大小：如果方法返回正整数，则表示`o1`大于`o2`；如果返回0，表示相等；返回负整数，表示`o1`小于`o2`

3. 可以将`Comparator`传递给`sort`方法(如`Collections.sort`)或`Arrays.sort`，从而允许在排序顺序上事项精确控制

4. 还可以使用`Comparator`来控制某些数据结构(如有序`set`或有序映射)的顺序，或者为那些没有自然顺序的对象`collection`提供排序

   ```java
   @Test
   public void test(){
   String[] arr = new String[]{"AA", "BB", "PP", "GG", "CC"};
       Arrays.sort(arr, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return -o1.compareTo(o2);
           }
       });
       System.out.println(Arrays.toString(arr));
       // [PP, GG, CC, BB, AA]
   }
   ```

### 2.4 System类

1. `System`类代表系统类，系统级的很多属性和控制方法都放置在该类的内部该类位于`java.lang`包

2. 由于该类的构造器是`private`的，所以无法创建该类的对象，也就是无法实现化该类。其内部成员变量和成员方法都是`static`的，所以也可以很方便的进行调用

3. 成员变量：`System`类内部包含`in`、`out`、`err`三个成员变量，分别代表标准输入流`键盘输入`，标准输出流`显示器`和标准错误输出流`显示器`

4. 成员方法：

   `native long currentTimeMillis()`：返回当前的计算机时间，时间的表达格式为当前计算机时间和`GMT`时间(格林威治时间)`1970年1月1日0时0分0秒`所差的毫秒数

   `void exit(int status)`：该方法的作用是退出程序。其中`status`的值为`0`代表正常退出，非零代表异常退出。使用该方法可以在图形界面编程中实现程序的退出功能

   `void gc()`：该方法的作用是请求系统进行垃圾回收，至于系统是否立刻回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况

   `String getProperty(String key)`：该方法的作用是获得系统中属性名为`key`的属性对应的值。系统中常见的属性名及属性的作用如下

   | 属性名       | 属性说明           |
   | ------------ | ------------------ |
   | java.version | java运行时环境版本 |
   | java.home    | java安装目录       |
   | os.name      | 操作系统的名称     |
   | os.version   | 操作系统的版本     |
   | user.name    | 用户的账户名称     |
   | user.home    | 用户的主目录       |
   | user.dir     | 用户当前的工作目录 |

### 2.5 Math

1. `java.lang.Math`提供了一系列静态方法用于科学计算。其方法的参数和返回值类型一般为`double`型
2. `abs`：绝对值
3. `acos, asin, atan, cos, sin, tan`：三角函数
4. `sqrt`：平方根
5. `pow(double a, double b)`：a的b次幂
6. `log`：自然对数
7. `exp`：e为底指数
8. `max(double a, double b)`：最大值
9. `min(double a, double b)`：最小值
10. `random`：返回0.0到1.0的随机数
11. `long round(double a)`：`double`型数据a转换为`long`型(四舍五入)
12. `toDegrees(double angrad)`：弧度 --> 角度
13. `toRadians(double angdeg)`：角度 --> 弧度

### 2.6 BigInteger与BigDecimal

**Biginteger**

1. `Integer`类作为`int`的包转类，能存储的最大整数为`2^31-1`，`Long`类也是有限的，最大为`2^63-1`。如果要表示再大的整数，不管是基本数据类型还是他们的包装类都无能为力，更不用说进行计算了
2. `java.math`包的`BigInteger`可以表示不可变的任意精度的整数。`BigInteger`提供所有`java`的基本数据整数操作符的对应武，并提供`java.lang.Math`的所有相关方法。另外，`BigInteger`还提供以下运算：模算术、GCD计算、质数测试、素数生成、位操作以及一些其它操作
3. 构造器：`BigInteger(String val)`：根据字符串构建`BigInteger`对象

**Bigdecimal**与**BigInteger**相似主要用于处理浮点型的数据

## 3. 枚举类&注解

### 3.1 枚举类

- 类的对象只有有限个，确定的。
- 如果需要定义一组常量时，强烈建议使用枚举类
- 如果枚举类中只有一个对象，则可以作为单例模式的实现方式

#### 3.1.1 定义枚举类jdk5.0之前

```java
package enumtest;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring); // Season{seasonName='春天', seasonDesc='春暖花开'}
    }
}
// 自定义枚举类
class Season{
    // 1. 声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化的类的构造器
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "寒风刺骨");

    // 4. 获取属性
    public String getSeasonDesc() {
        return seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    // 5. toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
```

#### 3.1.2 定义枚举类jdk5.0之后

`enum`类默认继承于`java.lang.Enum`

```java
package enumtest;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring); // SPRING
    }
}
enum Season {

    // 1. 提供当前枚举类的多个对象, 多个对象之间用逗号隔开末尾用分号隔开
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "寒风刺骨");

    // 2. 声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    // 3. 私有化的类的构造器
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 获取属性
    public String getSeasonDesc() {
        return seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }
}
```

枚举类实现接口，正常情况下，直接实现即可，如果想让每一个枚举类对象实现不同的功能，那每一个枚举类都需要实现接口

```java
interface Info{
    void show();
}

enum Season implements Info{

    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("我是春天");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("我是夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("我是秋天");
        }
    },
    WINTER("冬天", "寒风刺骨"){
        @Override
        public void show() {
            System.out.println("我是冬天");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
}
```

#### 3.1.3 Enum类的主要方法

- `values()`：返回枚举类型的对象数组。该方法可以用来遍历所有的枚举值

  ```java
  for(int i = 0; i < spring.values().length; i++){
  	System.out.printf("%s ", spring.values()[i]);
  	// SPRING SUMMER AUTUMN WINTER SPRING
  }
  ```

- `valueOf(String str)`：把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的"名字",否则`IllegalArgumentException`

  ```java
  Season summer = Season.valueOf("SUMMER");
  System.out.println(summer); // SUMMER
  ```

- `toString()`：返回当前枚举类对象常量的名称

  ```java
  System.out.println(spring.toString()); // SPRING
  ```

### 3.2 注解Annotation

- 从`JDK5.0`开始，`java`增加了对元数据`MetaData`的支持，也就是`Annotation(注解)`
- `Annotation`其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。通过使用`Annotation`，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署
- `Annotation`可以像修饰符一样被使用，可用于修饰包、类、构造器、方法、成员变量、参数、局部变量的声明，这些信息诶保存在`Annotation`的`name=value`中
- `JPA`是基于注解的，`Spring2.5`以上都是基于注解的，`Hibernate3.x`以后也是基于注解的，`Struts2`有一部分也是基于注解趋势：`框架 = 注解 + 反射 + 设计模式`

#### 3.2.1 文档注解

`@author`标明开发该类模块的作者

`@version`标明该类模块的版本

`@see`参考转向，也就是相关主题

`@since`从那个版本开始增加的

`@param`对方法中参数的说明，没有参数不写。可并列多个

`@return`对方法返回值的说明，如果方法的返回值类型是`void`不写

`@exception`对方法可能抛出的异常进行说明，如果方法没有用`throws`显示抛出的异常就不能写其中，可并列多个

#### 3.2.2 编译时的格式检查

- `@Override`限定重写父类方法，该注解只能用于方法

  ```java
  class Person{
      private String name;
      private int age;
  
      @Override
      public String toString() {
          return "Person{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

- `@Deprecated`用于表示所修饰的元素(类、方法等) --> "已过时"。通常是因为所修饰的结构危险或存在更好的选择

- `@SuppressWarnings`抑制编译器警告

#### 3.2.3 跟踪代码的依赖性，实现替代配置文件功能

`Servlet3.0`提供的注解,使得不需要在`web.xml`文件中进行`servlet`的部署

#### 3.2.4 自定义注解

- 定义新的`Annotation`类型使用`@interface`关键字

  ```java
  public @interface MyAnnotation {
  }
  ```

- 自定义注解自动继承了`java.lang.annotation.Annotation`接口

- `Annotation`的成员变量在`Annotation`定义中以无参数方法的形式声明。其中方法名和返回值定义了该成员的名字和类型。称为配置参数。类型只能是八中基本数据类型、`String`、`Class`、`enum`、`Annotation`以上所有类型的数组

  ```java
  public @interface MyAnnotation {
      String value();
  }
  ```

- 可以定义`Annotation`的成员变量中为其指定初始值，指定成员变量的初始值可使用`default`关键字

  ```java
  public @interface MyAnnotation {
      String value() default "hello";
  }
  ```

- 如果只有一个参数成员，建议使用参数名为`value`

- 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。格式是"参数名=参数值"，如果只有一个参数成员，且名称为`value`，可以省略`value=`

  ```java
  @MyAnnotation
  class Person{
      private String name;
      private int age;
  }
  ```

- 没有成员定义的`Annotation`称为标记，包含成员变量的`Annotation`称为元数据`Annotation`

#### 3.2.5 元注解

元`Annotation`用于修饰其它`Annotation`定义，即对现有的注解进行修饰

1. `Retention`：指定所修饰的`Annotation`的声明周期：`SORCE`、`CLASS(默认行为)`、`RUNTIME`

   ```java
   @Retention(RetentionPolicy.RUNTIME)
   public @interface MyAnnotation {
       String value() default "hello";
   }
   ```

2. `Target`：指名注解能够修饰的结构

   ```java
   @Target({ElementType.TYPE, ElementType.FIELD})
   public @interface MyAnnotation {
       String value() default "hello";
   }
   ```

3. `Documented`：用于指定被该元`Annotation`修饰的`Annotation`类将被`javadoc`工具提取成文档。默认情况下，`javadoc`不包括注解：定义为`Documented`的注解必须设置`Retention`值为`RUNTIME`

   ```java
   @Retention(RetentionPolicy.RUNTIME)
   @Documented
   public @interface MyAnnotation {
       String value() default "hello";
   }
   ```

4. `Inherited`：被它修饰的`Annotation`将具有继承性。如果某个类使用了被`Inherited`修饰的`Annotation`则其子类将自动具有该注解

   ```java
   @Inherited
   public @interface MyAnnotation {
       String value() default "hello";
   }
   ```

#### 3.2.6 通过反射获取注解信息

```java
import org.junit.Test;
import java.lang.annotation.Annotation;

public class AnnotationTest {
    @Test
    public void test(){
        Class<Student> studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for(int i = 0; i < annotations.length; i++){
            System.out.println(annotations[i]); // MyAnnotation(value="hello")
        }
    }
}
@MyAnnotation
class Person{

}
class Student extends Person{

}
```

#### 3.2.7 JDK8注解新特性

可重复注解

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
```



```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "hello";
}
```



```java
@MyAnnotation(value = "hello")
@MyAnnotation(value = "world")
class Person{

}
```

#### 3.2.8 类型注解

`ElementType.TYPE_PARAMETER`：表示该注解能写在类型变量的声明语句中

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "hello";
}
```

```java
class Animal<@MyAnnotation T> {
    
}
```

`ElementType.TYPE_USE`：表示该注解能写在使用类型的任何语句中

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "hello";
}
```

```java
@Test
public void test(){
    ArrayList<@MyAnnotation String> list = new ArrayList<>();
    int num = (@MyAnnotation int)10L;
}
```

## 4. java 集合

### 4.1 集合框架的概述

集合，数组都是对多个数据进行存储操作的结构，简称`java`容器

`java`集合可以分为`Collection`和`Map`两种体系

- `Collection`接口：单列数据，定义了存储一组对象的方法的集合

  `List接口`：元素有序、可重复的集合。实现类：`ArrayList`、`LinkedList`、`Vector`

  `Set接口`：元素无序、不可重复的集合。实现类：`HashSet`、`LinkedHashSet`、`TreeSet`

- `Map接口`：双列集合，保存具有映射关系`key-value`对的集合。实现类：`HashMap`、`LinkedHashMap`、`TreeMap`、`Hashtable`、`Properties`

### 4.2 Collection接口

#### 4.2.1 Collection常用方法

创建`Collection`

```java
@Test
public void test(){
    Collection<Object> coll = new ArrayList<>();
}
```

- 添加元素`add(Object obj)`

  ```java
  coll.add("AA");
  coll.add(123);
  coll.add(LocalDateTime.now());
  ```

- 添加一个`Collection`对象

  ```
  coll.add(Collection coll);
  ```

- 获取集合的大小`int size()`

  ```java
  System.out.println(coll.size()); // 4
  ```

- 打印`toString()`

  ```java
  System.out.println(coll);
  // [AA, BB, 123, 2020-11-08T14:53:34.321726]
  ```

- 判断当前集合是否为空`boolean isEmpty()`

  ```java
  System.out.println(coll.isEmpty()); // false
  ```

- 清空集合元素`void clear()`

  ```java
  coll.clear();
  System.out.println(coll); // []
  ```

- 判断当前集合中是否包含obj `boolean contains(Object obj)`，`boolean containsAll(Collection coll)`判断`coll`所有的元素是否在当前对象中

  ```java
  coll.add(123);
  System.out.println(coll.contains(123)); // true
  // 如果是引用数据类型默认调用equals方法
  ```

- 移出某个元素`boolean remove(Object obj)`，返回是否移出成功。`removeAll(Collection coll)`，移出`coll`中的所有元素 --> 差集

- `retainAll(Object obj)`求并集

- `equals(Object obj)`判断两个集合是否相同

- 计算集合的哈希值

  ```java
  System.out.println(coll.hashCode()); // 493567911
  ```

- 集合转换为数组

  ```java
  Object[] arr = coll.toArray();
  for(int i = 0; i < arr.length; i++){
  	System.out.print(arr[i] + " "); 
      // AA BB 123 2020-11-08T18:51:30.305080
  }
  ```

- 数组转换为集合

  ```java
  List<String> list =  Arrays.asList(new String[]{"QQ", "UU", "中国"});
  ```

#### 4.2.2 迭代器

- `Iterator`对象称为迭代器(设计模式的一种)，主要用于遍历`Collection`集合中的元素。

- `GOF`给迭代器模式的定义为：提供一种方法访问一个容器`container`对象中各个元素，而又不暴露该对象的内部细节

- `Collection`接口继承了`java.lang.Iterable`接口，改接口有一个`iterator()`方法，那么所有实现了`Collection`接口的集合类都有一个`iterator()`方法，用以返回一个实现了`iterator`接口的对象

- `iterator`仅用于遍历集合，`iterator`本身并不提供承装对象的能力，如果需要创建`iterator`对象，则必须有一个被迭代的集合

- 集合对象每次调用`iterator()`方法都得到一个全新的迭代器对象，默认游标都在集合的第一个对象之前

- `hasNext()`判断是否还有下一个元素，`next()`获取下一个元素，`remove()`移出当前元素

  ```java
  package collection;
  
  import org.junit.Test;
  
  import java.util.ArrayList;
  import java.util.Collection;
  import java.util.Iterator;
  
  public class IteratorTest {
      @Test
      public void test(){
          Collection<Object> coll = new ArrayList<>();
          coll.add("qwer");
          coll.add(123);
          coll.add(false);
  
          Iterator iterator = coll.iterator();
          while(iterator.hasNext()) {
              System.out.println(iterator.next());
              	// qwer
  				// 123
  				// false
          }
      }
  }
  ```

#### 4.2.3 foreach

- `java5.0`提供了`foreach`循环迭代访问`Collection`和数组

- 遍历操作不需获取`Collection`或数组的长度，无需使用索引访问元素

- 遍历集合的底层调用`iterator`完成操作

  ```java
  @Test
  public void test(){
  	Collection<Object> coll = new ArrayList<>();
      coll.add(123);
      coll.add("ggghh");
      coll.add(LocalDateTime.now());
  
      for(Object value: coll) {
      	System.out.println(value);
      }
  }
  ```

#### 4.2.4 子接口List

**List概述**

- 鉴于`java`中数组用来存储数据的局限性，我们通常使用`List`替代数组

- `List`有三个实现类 `ArrayList`，`LinkedList`、`vector`

  `ArrayList`：是`List`的主要实现类，线程不安全，底层使用`Object`数组存储

  `vector`：线程安全，层使用`Object`数组存储，不推荐使用

  `LinkedList`：底层使用双向链表实现

**List接口方法**

```java
@Test
public void test(){
    ArrayList<Object> list = new ArrayList();
    list.add(123);
    list.add("ert");
}
```

- `void add(int index, Object ele)`：在`index`位置插入`ele`元素

  ```java
  list.add(1, LocalDateTime.now());
  System.out.println(list);
  // [123, 2020-11-09T12:19:38.689714, ert]
  ```

- `boolean addAll(int index, Collection eles)`：从`index`位置开始将`eles`中的所有元素添加进来

  ```java
  List<Object> tempList = Arrays.asList(1, 2, 3);
  list.addAll(1, tempList);
  System.out.println(list);
  // [123, 1, 2, 3, ert]
  ```

- `E get(int index)`：获取指定`index`位置的元素

  ```java
  System.out.println(list.get(1));
  // ert
  ```

- `int indexOf(Object obj)`：返回`obj`在集合中首次出现的位置，没有则返回`-1`

  ```java
  System.out.println(list.indexOf("ert"));
  // 1
  ```

- `int lastIndexOf(Object obj)`：返回`obj`在当前集合中末次出现的位置

- `E remove(int index)`：移除指定`index`位置的元素，并返回此元素，

  ```java
  list.remove(1);
  System.out.println(list);
  // [123]
  ```

- `E set(int index, Object ele)`：设置指定`index`位置的元素为`ele`

  ```java
  list.set(0, LocalDateTime.now());
  System.out.println(list);
  // [2020-11-09T12:29:57.484097, ert]
  ```

- `list subList(int fromIndex, int toIndex)`：返回从`fromIndex`到`toIndex`位置的子集合

- 自定义的类需要重写`equals()`方法，方便`remove`、`set`等方法的使用

#### 4.2.5 子接口set

- `Set`接口是`Collection`的子接口，`Set`没有提供额外的方法

- `Set`集合不允许包含相同的元素，如果添加两个相同的元素，则添加操作失败

- `Set`判断对象是否不是使用`==`运算符，而是根据`equals()`方法

- 实现类：

  `HashSet`：`Set`接口的主要实现类；线程不安全；

  `LinkedHashSet`是`HashSet`的子类，遍历其内部数据时，可以按照添加的顺序遍历

  `TreeSet`：底层使用红黑树存储，可以按照添加对象的指定属性，进行排序

- `Set`作为`Collection`的子接口，**没有**提供额外的方法

**Set的实现类：HashSet**

- `HashSet`是`Set`接口的典型实现，大多数时候使用`Set`集合时都使用这个实现类。

- `HashSet`按`Hash`算法来存储集合中的元素，因此具有很好的存取、查找、删除性能

- `HashSet`具有以下特点

  不能保证元素的排序顺序

  `HashSet`不是线程安全的

  集合元素可以是`null`

- 无序型：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是是根据数据的哈希值

  ```java
  @Test
  public void test(){
  Set<Object> set = new HashSet<>();
      set.add(456);
      set.add("AA");
      set.add(LocalDateTime.now());
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
      }
  }
  // AA 456 2020-11-09T17:25:57.837272
  // AA 2020-11-09T17:33:13.247174 456
  ```

- `HashSet`集合判断两个元素相等的标准：两个对象通过`hashCode`方法比较相等，并且两个对象的`equals()`方法返回值也相等

- 对于存在在`Set`容器中的对象，对应的类一定要重写`equals()`和`hashCode(Object obj)`方法，以实现对象相等规则。即："相等的对象必须具有相等的散列码"

- 添加元素的过程

  调用元素`obj`所在类的`hashCode()`方法，计算元素的哈希值

  此哈希值接着通过某种算法计算出在`HashSet`底层数组中存放的位置，判断数组此位置上是否已经有元素

  如果此位置没有其他元素直接添加`obj`到此位置，

  如果此位置上有元素(或以链表形式存在的多个元素)，则比较元素`obj`(或者遍历链表进行比较)与其他元素的`hash`值，如果`hash`值不相同，则元素`obj`添加成功；如果`hash`值相同，进而调用`obj`所在类的`equlas`方法，如果返回`true`添加成功，否则失败(链表放在表头)

- `hashCode()`重写

  ```java
  @Override
  public int hashCode() {
  	return Objects.hash(name, age);
  }
  ```

**Set的实现类：LinkedHashSet**

遍历其内部数据时，可以按照添加的顺序遍历，对于频繁的遍历操作，效率高于`HashSet`

**Set的实现类：TreeSet**

- 向`TreeSet`中添加的数据，要求是想同类的对象

- `TreeSet`采用红黑树的存储结构

- `TreeSet`中的数据是有序的

  ```java
  @Test
  public void test(){
  TreeSet<Integer> set = new TreeSet<>();
      set.add(99);
      set.add(34);
      set.add(1024);
      set.add(0);
      System.out.print(set + " ");
      // [0, 34, 99, 1024]
  }
  ```

- 对于添加自定义的类需要是可比较的，实现`Comparable`接口。属于自然排序

  ```java
  import org.junit.Test;
  import java.util.TreeSet;
  
  public class TreeSetTest {
      @Test
      public void test(){
          TreeSet<User> set = new TreeSet<>();
          set.add(new User("Tom", 18));
          set.add(new User("Bob", 28));
          set.add(new User("Jack", 18));
          set.add(new User("Alice", 78));
          System.out.println(set);
          // [User{name='Alice', age=78}, User{name='Bob', age=28}, User{name='Jack', age=18}, User{name='Tom', age=18}]
      }
  }
  
  class User implements Comparable{
      private String name;
      private int age;
  
      public User(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "User{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  
      @Override
      public int compareTo(Object o) {
          if (o instanceof User) {
              User user = (User)o;
              return this.name.compareTo(user.name);
          }
          throw new ClassCastException("类型不匹配");
      }
  }
  ```

- 定制排序，创建`TreeSet`对象时传入`Comparator`对象

  ```java
  import org.junit.Test;
  
  import java.util.Comparator;
  import java.util.TreeSet;
  
  public class TreeSetTest {
      @Test
      public void test(){
          TreeSet<User> set = new TreeSet<>(new Comparator<User>() {
              @Override
              public int compare(User o1, User o2) {
                  int result = -o1.getName().compareTo(o2.getName());
                  if (result == 0) {
                      result = o1.getAge() - o2.getAge();
                  }
                  return result;
              }
          });
          set.add(new User("Tom", 18));
          set.add(new User("Bob", 28));
          set.add(new User("Jack", 18));
          set.add(new User("Jack", 58));
          set.add(new User("Alice", 78));
          System.out.println(set);
          // [User{name='Tom', age=18}, User{name='Jack', age=18}, User{name='Jack', age=58}, User{name='Bob', age=28}, User{name='Alice', age=78}]
      }
  }
  
  class User{
      private String name;
      private int age;
  
      public User(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public int getAge() {
          return age;
      }
  
      public String getName() {
          return name;
      }
  
      @Override
      public String toString() {
          return "User{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

### 4.3 Map接口

- `Map`:双列数据，存储`key-value`对的数据
- 继承关系

```mermaid
graph TD
Map --> Hashtable
Map --> HashMap
Map --> SortedMap
Hashtable --> Properties
HashMap --> LinkedHashMap
SortedMap --> TreeMap
```

- `HashMap`：是`Map`主要的实现类，线程不安全，可以存储`null`的`key-value`，底层实现数组+链表+红黑树

- `LinkedHashMap`：`HashMap`的子类：保证遍历`map`元素时，可以按照添加的顺序实现遍历，底层双向链表结构

- `TreeMap`：是`Map`有序的实现类，对添加的`key-value`进行排序，实现排序遍历，考虑`key`的自然排序或定制排序,底层使用红黑树实现

- `Hashtable`：线程安全的，不能存储`null`的`key-value`

- `Properties`：`Hashtable`的子类，常用来配置文件。`key`和`value`都是`String`类型

- `Map`结构的理解

  `Map`中的`key`：无序的、不可重复的，使用`Set`存储所有的`key`。即`key`所在的类要重写`equals()`和`hashCode()`方法(`HashMap`为例)

  `Map`中的`value`：无序的、可重复的，使用`Collection`存储所有的`value`。`value`所在的类要重写`equals()`

  一个键值对：`key-value`构成了一个`Entry`对象

  `Map`中的`entry`：无序的、不可重复的，使用`Set`存储所有的`entry`

#### 4.3.1 HashMap的底层

**`JDK7`的实现原理**

```java
HashMap map = new HashMap();
// 实例化后底层创建了长度是16的一维数组Entry[] table
```

**存储过程**

```java
map.put(key1, value1);
```

1. 首先，调用`key1`所在类的`hashCode()`计算`key1`哈希值，此哈希值经过计算后，得到`Entry`数组中存放位置

2. 如果此位置上的数据为空，此时的`key-value`添加成功

3. 如果此位置上的数据不为空，则比较`key`和已经存在的一个或多个数据的哈希值

   如果`key`的哈希值与已经存在的数据的哈希值都不相同，此时的`key-value`添加成功

   如果`key`的哈希值和已经存在的某一个数据的哈希值相同，继续比较`equals()`方法：`equals()`返回`false`，添加成功；否则使用`value`替换原来的`value`

4. 多个`value`存在相同的位置，是以链表的形式进行存储

5. 在不断的添加过程中，当大小超过其临界值且要存放的位置非空，会扩容为原来容量的2倍。

**JDK8相较于JDK7的不同之处**

- `new HashMap()`：底层并没有创建数组

- 首次调用`put(key, value)`方法时，底层才会创建长度为`16`的数组

- `JDK8`底层的数组的名称为`Node[]`

- `JDK7`底层结构只有：数组+链表，`JDK8`中：数组+链表+红黑树

  当数组的某一个索引位置上的元素以链表形式存在的数据个数`>8`且当前数组的长度`>64`时，此时此索引位置上的所有数据改为使用红黑树存储

**HashMap底层常量**

- `DEFAULT_INITIAL_CAPACITY`：`HashMap`的默认容量`16`
- `DEFAULT_LOAD_FACTOR`：`HashMap`的默认加载因子
- `threshold`：扩容的临界值 = 容量 * 加载因子
- `TREEIFY_THRESHOLD`：`Bucket`中链表长度大于该默认值，转换为红黑树
- `MIN_TREEIFY_CAPACITY`：数组中`Node`被树化时最小的`hash`表容量：`64`

#### 4.3.2 Map常用方法

```java
@Test
public void test(){
    Map<Object, Object> map = new HashMap<>();
}
```

**添加、删除、操作**

- `Object put(Object key, Object value)`：将指定`key-value`添加到(或修改)当前`map`对象中

  ```java
  map.put(123, "AA"); // 添加
  map.put("BB", 456);
  map.put(123, "CC"); // 修改
  System.out.println(map); // {BB=456, 123=CC}
  ```

- `void putAll(Map m)`：将m中的所有`key-value`存放到当前`map`中

- `Object remove(Object key)`：移出指定`key`的`key-value`返回`value`

  ```java
  map.put("移除", 123);
  System.out.println(map); // {移除=123}
  System.out.println(map.remove("移除")); // 123 不存在返回null
  System.out.println(map); // {}
  ```

- `void clear()`：清空`map`

**元素查询**

- `Object get(Object key)`：获取指定`key`对应的`value`

  ```java
  map.put(123, "Hello World");
  System.out.println(map.get(123)); // Hello World // 没有返回null
  ```

- `boolean containsKey(Object key)`：是否包含指定的`key`

  ```java
  map.put(123, "Hello World");
  System.out.println(map.containsKey(123)); // true
  ```

- `int size()`：返回`map`中`key-value`对的个数

  ```java
  System.out.println(map.size()); // 0
  ```

- `boolean isEmpty()`：判断当前`map`是否为空

  ```java
  System.out.println(map.isEmpty()); // true
  ```

- `boolean equals(Object obj)`：判断当前`map`和参数对象`obj`是否相等

  ```java
  System.out.println(map.equals(map)); // true
  ```

**元视图操作的方法**

- `Set keySet()`：返回所有`key`构成的`Set`集合

  ```java
  @Test
  public void test1(){
      Map<Object, Object> map = new HashMap<>();
  
      map.put(123, "AA");
      map.put("BB", 456);
      map.put("456", 999);
      map.put("NowTime", LocalDateTime.now());
      Set set =  map.keySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()){
      	System.out.println(iterator.next());
      }
  }
  // BB
  // 456
  // NowTime
  // 123
  ```

- `Collection values()`：返回所有`values`构成的`Collection`

  ```java
  Collection coll =  map.values();
  Iterator iterator = coll.iterator();
  while(iterator.hasNext()){
  	System.out.println(iterator.next());
  }
  // 456
  // 999
  // 2020-11-10T15:58:45.581643
  // AA
  ```

- `Set entrySet()`：遍历`key-value`

  ```java
  Set entrySet = map.entrySet();
  Iterator iterator = entrySet.iterator();
  while(iterator.hasNext()) {
      Object obj = iterator.next();
      Map.Entry entry = (Map.Entry) obj;
      System.out.println(entry.getKey() + ": " + entry.getValue());
  }
  // BB: 456
  // 456: 999
  // NowTime: 2020-11-10T16:03:08.947608
  // 123: AA
  ```


#### 4.3.1 TreeMap

`TreeMap`中添加的`key-value`，要求必须是由同一个类创建的对象，涉及到`key`排序，遍历`TreeMap`会按照添加的顺序

自然排序

```java
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TreeMapTest {
    @Test
    public void test(){
        Map<User, Integer> map = new TreeMap<>()
        map.put(new User("Tom", 23), 98);
        map.put(new User("Bob", 15), 100);
        map.put(new User("Jack", 34), 90);
        map.put(new User("Alice", 22), 91);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
class User implements Comparable{
    String name;
    int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            int result = this.name.compareTo(user.name);
            if (result == 0) {
                result = this.age - user.age;
            }
            return  result;
        }
        throw new ClassCastException("类型转换错误");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
// User{name='Alice', age=22}: 91
// User{name='Bob', age=15}: 100
// User{name='Jack', age=34}: 90
// User{name='Tom', age=23}: 98
```

**定制排序**

```java
import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    @Test
    public void test(){
        Map<User, Integer> map = new TreeMap<>(new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                int result = o1.name.compareTo(o2.name);
                if (result == 0) {
                    result = o1.age - o2.age;
                }
                return  -result;
            }
        });
        map.put(new User("Tom", 23), 98);
        map.put(new User("Bob", 15), 100);
        map.put(new User("Jack", 34), 90);
        map.put(new User("Alice", 22), 91);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
class User{
    String name;
    int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
// User{name='Tom', age=23}: 98
// User{name='Jack', age=34}: 90
// User{name='Bob', age=15}: 100
// User{name='Alice', age=22}: 91
```

#### 4.3.2 Properties

- `Properties`类是`Hashtable`的子类，该对象用于处理属性文件

- 由于属性文件里的`key`、`value`都是字符串类型，所以`Properties`里的`key`和`value`都是**字符串**类型

- 存取数据时，建议使用`setProperty(String key, String value)`方法和`getProperty(String key)`方法

- 具体用法

  在项目根目录下创建`jdbc.properties`

  ```java
  name=Tom
  password=123456
  ```

  使用`Properties`类

  ```java
  import org.junit.Test;
  
  import java.io.FileInputStream;
  import java.io.IOException;
  import java.util.Properties;
  
  public class PropertiesTest {
      @Test
      public void test(){
          FileInputStream fis = null;
          try{
              Properties pros = new Properties();
              fis = new FileInputStream("jdbc.properties");
              pros.load(fis); // 加载流对应的文件
  
              // 获取对应的属性
              String name = pros.getProperty("name");
              String password = pros.getProperty("password");
  
              System.out.println("name: " + name + "\npassword: " + password);
          } catch (IOException e){
              e.printStackTrace();
          } finally {
              // 关闭流
              if (fis != null) {
                  try {
                      fis.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }
      }
  }
  
  // name: Tom
  // password: 123456
  ```

### 4.4 Collections工具类

- `Collections`是一个操作`Set`、`List`、`Map`等集合的工具类
- `Collections`中提供了一系列静态的方法对元素进行排序、查询和修改等操作，还提供了对集合对象设置不可变、对集合对象实现同步控制等方法

#### 4.4.1 常用方法

```java
@Test
public void test(){
    List<Integer> list = new LinkedList<>();
    list.add(123);
    list.add(456);
    list.add(0);
    list.add(23);
    list.add(100);
    System.out.println(list);
    // [123, 456, 0, 23, 100]
}
```

- `reverse(List)`反转`List`中元素的排序

  ```java
  Collections.reverse(list);
  System.out.println(list);
  // [100, 23, 0, 456, 123]
  ```

- `shuffle(List)`对`List`中元素进行随机排序

  ```java
  Collections.shuffle(list);
  System.out.println(list);
  // [23, 100, 123, 0, 456]
  ```

- `sort(List, Comparator)`：根据指定的`Comparator`产生的顺序对`List`集合元素进行排序

  ```java
  Collections.sort(list);
  System.out.println(list);
  // [0, 23, 100, 123, 456]
  
  Collections.sort(list, new Comparator<Integer>() {
  	@Override
  	public int compare(Integer o1, Integer o2) {
  		return o2 - o1;
  	}
  });
  System.out.println(list);
  // [456, 123, 100, 23, 0]
  ```

- `swap(List, int i, int j)`：将指定`List`集合中的`i`处元素和`j`处元素进行交换

  ```java
  Collections.swap(list, 0, 1);
  System.out.println(list);
  // [456, 123, 0, 23, 100]
  ```

- `int frequency(List list, Objec o)`：返回`o`出现的次数

  ```java
  System.out.println(Collections.frequency(list, 0));
  // 1
  ```

- `void copy(List dest, List src)`：拷贝`List`到另一个`List`中

  ```java
  // 目的List要保证大小和src相同
  List<Integer> dest = Arrays.asList(new Integer[list.size()]);
  Collections.copy(dest, list);
  System.out.println(dest);
  // [123, 456, 0, 23, 100]
  ```

#### 4.4.2 同步控制

`Collections`类中提供了多个`synchronizedXxx`的方法，该方法可使指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题

```java
List syncList = Collections.synchronizedList(list);
```

## 5. 泛型

### 5.1 泛型概述

所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。这个类型参数将在使用时(继承或实现这个接口，用这个类型声明变量、创建对象时)确定(即出入实际的类型参数，也称为类型实参)

泛型类，实例化时没有指明类的泛型，则默认泛型类型为`Object`类型

```java
@Test
public void test(){
    Map<String, Integer> map = new HashMap<>();
    map.put("Tom", 87);
    map.put("Jerry", 87);
    map.put("Jack", 67);

    // 泛型的嵌套
    Set<Map.Entry<String, Integer>> entry = map.entrySet();
    Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
    while(iterator.hasNext()) {
        Map.Entry<String, Integer> e = iterator.next();
        System.out.println(e.getKey() + ": " + e.getValue());
    }
}
// Tom: 87
// Jerry: 87
// Jack: 67
```

### 5.2 自定义泛型结构

```java
public class Order<E> {
    private String orderName;
    private int orderId;
    private E orderE;

    public Order(){}
    public Order(String orderName, int orderId, E orderE) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderE = orderE;
    }

    public E getOrderE(){
        return orderE;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderE=" + orderE +
                '}';
    }
}
```

对于子类继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型

```java
public class subClass extends Order<Integer> {
    
}
```

如果不指明泛型类型，则实例化时需要指明泛型,泛型继承不具有子父类关系

```java
class subClass<E> extends Order<E> {
    
}
```

泛型类可能有多个参数，此时应该将多个参数一起放在尖括号里

```java
<E1, E2, E3>
```

泛型不同的引用不能相互赋值

```java
ArrayList<String> list1 = new ArrayList<>();
ArrayList<Integer> list2 = new ArrayList<>();
// 不能相互赋值
```

如果泛型结构是一个接口或者抽象类，则不可创建泛型类的对象

在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法中不能使用类的泛型

异常类不能是泛型的

对于泛型数组

```java
E[] arr = (E[])new Object[capacity];
```

泛型方法：与方法所在类是不是泛型没有关系，泛型方法可以声明为`static`

```java
public static <T> List<T> example(T element){
	
}
```

### 5.3 通配符

#### 5.3.1 通配符的基本使用

- 通配符`?`

  ```java
  @Test
  public void test1() {
      List<Object> list1 = null;
      List<String> list2 = null;
  
      List<?> list = null;
      list = list1;
      list = list2;
  }
  ```

- 遍历

  ```java
  public void print(List<?> list) {
      Iterator<?> iterator = list.iterator();
      while(iterator.hasNext()) {
      	System.out.println(iterator.next());
      }
  }
  ```

- 如果使用了通配符，则不能向`List<?>`中添加(写入)除`null`以外的数据,但是可以读取数据，获取的数据类型为`Object`

#### 5.3.2 通配符的限制

类

```java
class Animal{

}

class Dog extends Animal{

}
```

`? extends parent`：小于等于`parent`

`? super parent`：大于等于`parent`

```java
public void test3(){
    List<? extends Animal> list1 = new LinkedList<>();
    List<? super Animal> list2 = new LinkedList<>();

    List<Animal> list3 = new LinkedList<>();
    List<Dog> list4 = new LinkedList<>();
    List<Object> list5 = new LinkedList<>();

    list1 = list3;
    list1 = list4;

    list2 = list3;
    list2 = list5;
}
```

有限制符的修饰可以添加符合限制的元素

## 6. IO流

### 6.1 File类的使用

#### 6.1.1 File类的创建

- `java.io.File`类：文件和文件目录路径的抽象表示形式，与平台无关

- `File`能新建、删除、重命名文件目录，但`File`不能访问文件内容本身。如果需要访问文件内容本身，则需要使用输入/输出流

- 想要在`java`程序中表示一个真实存在的文件或目录，那么必须有一个`File`对象，但`java`程序中的一个`File`对象，可能没有一个真实存在的文件或目录

- `File`对象可以作为参数传递给流的构造器

- 构造器

  以`pathname`为路径创建`File`对象，可以是绝对路径或者相对路径，如果`pathname`是相对路径，则默认的当前路径在系统属性`user.dir`中存储

  ```java
  File file1 = new File("1.txt");
  ```

  以`parent`为父路径，`child`为子路径创建`File`对象

  ```java
  File file2 = new File("/home/valid/code/java/基础语法", "day10");
  ```

  根据一个父`File`对象和子文件路径创建`File`对象

  ```java
  File file3 = new File(file2, "1.txt");
  ```

- 路径分隔符

  ```
  windows: \\
  unix: /
  ```

#### 6.1.2 File类的获取功能

```java
@Test
public void test1(){
    File file = new File("hello.txt");
    File dir = new File("/home/valid/code/java/基础语法/day10/test");
}
```

- `String getAbsoultePath()`：获取绝对路径

  ```java
  System.out.println(file.getAbsolutePath());
  // /home/valid/code/java/基础语法/day10/hello.txt
  ```

- `String getPath()`：获取路径

  ```java
  System.out.println(file.getPath());
  // hello.txt
  ```

- `String getName()`：获取文件或目录名称

  ```java
  System.out.println(file.getName());
  // hello.txt
  ```

- `String getParent()`：获取文件或目录的上一级目录

  ```java
  System.out.println(file.getParent());
  // null 因为当前创建的时候使用的相对路径，所以找不到父目录
  ```

- `long lenght()`：获取文件的大小

  ```java
  System.out.println(file.length());
  // 0
  ```

- `long lastModified()`：获取最后一次修改的时间戳

  ```java
  System.out.println(file.lastModified());
  // 1605080166485
  ```

- `String[] list()`：获取指定目录下的所有文件或者文件目录的名称数组

  ```java
  String[] list = dir.list();
  for(String f : list) {
  	System.out.println(f);
  }
  // 1.txt
  // te
  ```

- `File[] listFiles() `：获取目录下的文件或目录的File对象

  ```java
  File[] listRoute = dir.listFiles();
  for(File f : listRoute) {
  	System.out.println(f);
  }
  // /home/valid/code/java/基础语法/day10/test/1.txt
  // /home/valid/code/java/基础语法/day10/test/te
  ```

#### 6.1.3 File类的重命名

`boolean renameTo(File dest)`：把文件重命名为指定的文件路径，目的文件应该不存在

```java
File dest = new File("world.txt");
System.out.println(file.renameTo(dest));
// true
```

#### 6.1.4 File类的判断功能

- `boolean isDirectory()`：判断是否是文件目录

  ```java
  System.out.println(file.isDirectory()); // false
  System.out.println(dir.isDirectory()); // true
  ```

- `boolean isFile()`：判断是否是文件

  ```java
  System.out.println(file.isFile()); // true
  System.out.println(dir.isFile());  // false
  ```

- `boolean exists()`：判断是否存在

  ```java
  System.out.println(file.exists()); // true
  ```

- `boolean canRead()`：判断是否可读

  ```java
  System.out.println(file.canWrite()); // true
  ```

- `boolean canWrite()`：判断是否可写

  ```java
  System.out.println(file.canWrite()); // true
  ```

- `boolean canExecute()`：判断是否可执行

  ```java
  System.out.println(file.canExecute()); // false
  ```

- `boolean isHidden()`：判断是否隐藏

  ```java
  System.out.println(file.isHidden()); // false
  ```

#### 6.1.5 File类的创建删除功能

- `boolean createNewFile()`：创建文件。若文件存在，则不创建，返回`false`。`boolean delete()`删除文件或文件夹

  ```java
  File file = new File("word.txt");
  if(!file.exists()) {
      try {
      	file.createNewFile();
      	System.out.println("创建成功");
      } catch (IOException e) {
      	e.printStackTrace();
      }
  } else {
  	file.delete();
  	System.out.println("删除成功");
  }
  ```

- `boolean mkdir()`：创建文件目录。如果此文件目录存在，不创建。如果此文件目录的上层目录不存在，也不创建。`boolean mkdirs()`：创建文件目录。如果上层文件目录不存在，一并创建。如果创建文件或者目录没有写盘符`windows下`，默认在项目目录下。即`mkdirs`是递归创建文件目录

  ```
  File dir = new File("/home/valid/code/java/基础语法/day10/tes/practice");
  if(dir.mkdirs()) {
  	System.out.println("创建成功");
  } else {
  	System.out.println("创建失败");
  }
  ```

### 6.2 IO流原理及流的分类

#### 6.2.1 IO原理

- `I/O`是`Input/Output`的缩写，`I/O`技术是非常使用的技术，用于处理设备之间的数据传输。文件读写，网络通信
- `Java`程序中，对于数据的输入输出操作以`流(stream)`的方式进行
- `java.io`包下提供了各种`流`类的和接口，用以获取不同种类的数据，并通过标准的方法输入或输出数据
- 输入`input`：读取外部数据(磁盘、光盘等存储设备的数据)到程序(内存中)
- 输出`output`：将程序`内存`数据输出到磁盘、光盘等存储设备中

#### 6.2.2 流的分类

- 按照操作单位不同分为：字节流`8bit`，字符流`16bit`
- 按数据流的流向不同分为：输入流，输出流
- 按流的角色的不同分为：节点流，处理流
- 所有的流都是以下四个抽象基类的子类

| 抽象基类 | 字节流       | 字符流 |
| -------- | ------------ | ------ |
| 输入流   | InputStream  | Reader |
| 输出流   | OutputStream | Writer |

- 节点流(或者称为文件流)有以下四个

  ```java
  FileInputStream
  FileOutputStream
  FileReader
  FileWriter
  ```


### 6.3 File读入

在当前项目下新建`hello.txt`并输入`helloworld`

1. 实例化`File`类的对象，指明要操作的文件

   ```java
   File file = new File("hello.txt");
   ```

2. 提供具体的流

   ```java
   FileReader fr = new FileReader(file);
   ```

3. 读入数据：`read()`返回读入的一个字符，到文件末尾返回`-1`

   ```java
   int data = fr.read();
   while(data != -1) {
       System.out.print((char) data);
       data = fr.read();
   }
   // helloworld
   ```

4. 关闭流

   ```java
   fr.close();
   ```

5. 流的操作都会有异常，尽量使用`try-catch`处理，因为流一定要被关闭

   ```java
   @Test
   public void test(){
       FileReader fr = null;
       try {
           File file = new File("hello.txt");
       	fr = new FileReader(file);
   
           int data = fr.read();
           while(data != -1) {
               System.out.print((char) data);
               data = fr.read();
           }
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (fr != null)
                   fr.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   ```

**利用`char[]`数组读入**

```java
char[] cbuf = new char[5];
int num = 0;
while((num = fr.read(cbuf)) != -1) {
    for(int i = 0; i < num; i++){
    	System.out.print(cbuf[i]);
        // System.out.print(new String(cbuf, 0, num));
    }
}
```

对于文本文件应当使用字符流来处理

### 6.4 File写出

当前项目根目录新建`hello.txt`空文件

1. 提供File类的对象，指明写出到的文件

   ```java
   File file = new File("hello.txt");
   ```

2. 提供`FileWriter`的对象，用于数据的写出，此时的`file`对象可以不存在，如果不存在则新建。写入默认是覆盖，如果想要追加则指定第二参数为`true`

   ```java
   FileWriter fw = new FileWriter(file);
   // FileWriter fw = new FileWriter(file, true);
   ```

3. 写出的操作

   ```java
   fw.write("Hello Java");
   fw.write(" I want to learn Java");
   ```

4. 流资源的关闭

   ```java
   fw.close();
   ```

5. 异常处理

   ```java
   @Test
   public void test1() {
       FileWriter fw = null;
       File file = new File("hello.txt");
       try {
           fw = new FileWriter(file, true);
   
           fw.write("Hello Java");
           fw.write(" I want to learn Java");
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (fw != null)
               	fw.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   ```

### 6.5 字节流

将当前项目目录下的`fgdjk.jpg`拷贝到当前项目目录下的`test.jpg`

1. 提供`File`类的对象

   ```java
   File src = new File("fgdjk.jpg");
   File dest = new File("test.jpg");
   ```

2. 提供`src`的`FileInputStream`和`dest`的`FileOutputStream`

   ```java
   FileInputStream fisSrc = new FileInputStream(src);
   FileOutputStream fisDest = new FileOutputStream(dest, true);
   ```

3. 读和写

   ```java
   byte[] cbuf = new byte[10];
   int num;
   while((num = fisSrc.read(cbuf)) != -1) {
   	fisDest.write(cbuf, 0, num);
   }
   ```

4. 关闭资源

   ```java
   fisSrc.close();
   fisDest.close();
   ```

5. 异常处理

   ```java
   @Test
   public void test() {
       FileInputStream fisSrc = null;
       FileOutputStream fisDest = null;
       try {
           File src = new File("fgdjk.jpg");
           File dest = new File("test.jpg");
   
           fisSrc = new FileInputStream(src);
           fisDest = new FileOutputStream(dest, true);
   
           byte[] cbuf = new byte[10];
           int num;
           while((num = fisSrc.read(cbuf)) != -1) {
           	fisDest.write(cbuf, 0, num);
           }
       }  catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (fisSrc != null)
                   fisSrc.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
           try {
               if(fisDest != null)
                   fisDest.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
       }
   }
   ```

对于非文本文件，应当使用字节流处理

### 6.6 缓冲流

缓冲流是对于节点流的包装

```mermaid
graph LR
FileInputStream --> BufferedInputStream
FileOutputStream --> BufferedOutputStream
FileReader --> BufferedReader
FileWriter --> BufferedWriter
```

1. 获取文件对象

   ```java
   File srcFile = new File("fgdjk.jpg");
   File destFile = new File("test.jpg");
   ```

2. 获得节点流

   ```java
   FileInputStream src = new FileInputStream(srcFile);
   FileOutputStream dest = new FileOutputStream(destFile);
   ```

3. 获取缓冲流

   ```java
   BufferedInputStream bis = new BufferedInputStream(src);
   BufferedOutputStream bos = new BufferedOutputStream(dest);
   ```

4. 读取和写入

   ```java
   byte[] buffer = new byte[10];
   int len;
   while((len = bis.read(buffer)) != -1) {
   	bos.write(buffer, 0, len);
   }
   ```

5. 关闭流资源，如果关闭了缓冲流，相应的节点流也会被关闭

   ```java
   bis.close();
   bos.close();
   ```

6. 异常处理

   ```java
   @Test
   public void test() {
       FileInputStream src = null;
       FileOutputStream dest = null;
   
       BufferedInputStream bis = null;
       BufferedOutputStream bos = null;
       try {
           File srcFile = new File("fgdjk.jpg");
           File destFile = new File("test.jpg");
   
           src = new FileInputStream(srcFile);
           dest = new FileOutputStream(destFile);
   
           bis = new BufferedInputStream(src);
           bos = new BufferedOutputStream(dest);
   
           byte[] buffer = new byte[1024];
           int len;
           while((len = bis.read(buffer)) != -1) {
           bos.write(buffer, 0, len);
           }
   
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (bis == null)
               bis.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
           try {
               if (bos == null)
               bos.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
       }
   }
   ```

7. 使用缓冲流能够显著提高文件读写错误的原因时，缓冲流的内部提供了一个默认大小为`8192`的缓冲区

### 6.7 转换流

- 转换流提供了在字节流和字符流之间的转换

- `java`提供了俩个转换流

  `InputStreamReader`：将`InputStream`转换为`Reader`，即将一个字节的输入流转换为字符的输入流

  `OutputStreamWriter`：将`Writer`转换为`OutputStream`，即将一个字符的输出流转换为字节的输出流

- 字节流中的数据都是字符时，转换为字符流更高效

- 很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能

`hello.txt`(UTF-8编码)的内容，以`GBK`的格式输出到`word.txt`

1. 获取文件对象

   ```java
   FileInputStream fis = new FileInputStream("hello.txt");
   FileOutputStream fos = new FileOutputStream("word.txt");
   ```

2. 设置转换流

   ```java
   // 使用系统默认的字符集
   // InputStreamReader isr = new InputStreamReader(fis);
   
   InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
   OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
   ```

3. 读取数据

   ```java
   char[] cbuf = new char[10];
   int len;
   while((len = isr.read(cbuf)) != -1) {
   	osw.write(cbuf, 0, len);
   }
   ```

4. 关闭流

   ```java
   isr.close();
   osw.close();
   ```

5. 异常处理

   ```java
   @Test
   public void test() {
       FileInputStream fis = null;
       FileOutputStream fos = null;
   
       InputStreamReader isr = null;
       OutputStreamWriter osw = null;
       try {
           fis = new FileInputStream("hello.txt");
           fos = new FileOutputStream("word.txt");
   
           isr = new InputStreamReader(fis, "UTF-8");
           osw = new OutputStreamWriter(fos, "GBK");
   
           char[] cbuf = new char[10];
           int len;
           while((len = isr.read(cbuf)) != -1) {
               osw.write(cbuf, 0, len);
           }
   
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               if (isr != null)
                   isr.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
   
           try {
               if (osw != null)
                   osw.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   ```

### 6.8 其它流

#### 6.8.1 标准输入、输出流

- `System.in`：标准的输入流，默认从键盘输入
- `System.out`：标准的输出流，默认从控制台输出
- 可以通过`System`类的`setIn(InputStream is)/setOut(PrintStream ps)`方式重新指定输入和输出的流

从键盘输入字符串，要求将读取到的整数字符串转换为大写输出。然后继续进行输出操作，只直输出`e`或者`exit`时退出程序

1. 获取输入流，`System.in`是字节流，需要转换为字符流

   ```java
   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader br = new BufferedReader(isr);
   ```

2. 读取数据

   ```java
   String str;
   while(true) {
       str = br.readLine();
       if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
       	break;
       }
       System.out.println(str.toUpperCase());
   }
   ```

3. 关闭流

   ```java
   br.close();
   ```

4. 异常处理

   ```java
   public void test() {
       InputStreamReader isr = null;
       BufferedReader br = null;
       try{
           isr = new InputStreamReader(System.in);
           br = new BufferedReader(isr);
           String str;
           while(true) {
           str = br.readLine();
           if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
           	break;
           }
           System.out.println(str.toUpperCase());
           }
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (br != null)
                   br.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   ```

#### 6.8.2 打印流

实现将基本数据类型的数据格式转化为字符串输出

打印流：`PrintStream`和`PrintWriter`

- 提供了一些`print()`和`println()`方法，用于多种数据类型的输出
- `PrintStream`和`PrintWriter`的输出不会抛出`IOException`异常
- `PrintStream`和`PrintWriter`有自动`flush`功能
- `PrintStream`打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用`PrintWriter`类
- `System.out`返回的是`PrintStream`的实例

将`ASCII`字符写入`world.txt`

1. 创建输出字节流和打印流

   ```java
   FileOutputStream fos = new FileOutputStream(new File("world.txt"));
   PrintStream ps = new PrintStream(fos, true);
   ```

2. 把标准输出流重定向到文件

   ```java
   if (ps != null) {
   	System.setOut(ps);
   }
   ```

3. 写出`ASCII`字符

   ```java
   for(int i = 0; i <= 255; i++){
       System.out.print((char) i);
       if (i % 50 == 0) {
       	System.out.println();
       }
   }
   ```

4. 关闭流

   ```java
   ps.close();
   ```

5. 异常处理

   ```java
   public static void test1(){
       FileOutputStream fos = null;
       PrintStream ps = null;
       try {
           fos = new FileOutputStream(new File("world.txt"));
           ps = new PrintStream(fos, true);
           if (ps != null) {
           	System.setOut(ps);
           }
           for(int i = 0; i <= 255; i++){
               System.out.print((char) i);
               if (i % 50 == 0) {
                   System.out.println();
               }
           }
       } catch (FileNotFoundException e) {
       	e.printStackTrace();
       } finally {
       	if (ps != null)
       		ps.close();
       }
   }
   ```

#### 6.8.3 数据流

- 为了方便地操作`Java`语言的基本数据类型和`String`的数据，可以使用数据流

- 数据流有两个类：用于读取和写出基本数据类型、`String`类的数据

  `DataInputStream`和`DataOutputStream`

  分别“套接”在`InputStream`和`OutputStream`子类的流上

**数据流写入**

1. 创建数据流

   ```java
   DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
   ```

2. 写入数据

   ```java
   dos.writeUTF("川建国");
   dos.flush();
   
   dos.writeInt(23);
   dos.flush();
   
   dos.writeBoolean(true);
   dos.flush();
   ```

3. 关闭流

   ```java
   dos.close();
   ```

4. 异常处理

   ```java
   public static void test2() {
       DataOutputStream dos = null;
       try {
           dos = new DataOutputStream(new FileOutputStream("data.txt"));
           dos.writeUTF("川建国");
           dos.flush();
   
           dos.writeInt(23);
           dos.flush();
   
           dos.writeBoolean(true);
           dos.flush();
   
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
           	if (dos != null)
           		dos.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
       }
   }
   ```

**数据流的读取**

1. 创建数据流

   ```java
   DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
   ```

2. 读取数据，读取的顺序必须与写入的数据相同

   ```java
   System.out.println(dis.readUTF());
   System.out.println(dis.readInt());
   System.out.println(dis.readBoolean());
   ```

3. 关闭流

   ```java
   dis.close();
   ```

4. 异常处理

   ```java
   public static void test(){
       DataInputStream dis = null;
       try{
           dis = new DataInputStream(new FileInputStream("data.txt"));
   
           System.out.println(dis.readUTF());
           System.out.println(dis.readInt());
           System.out.println(dis.readBoolean());
       } catch(IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (dis != null)
               	dis.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
       }
   }
   // 川建国
   // 23
   // true
   ```

#### 6.8.4 对象流

- `ObjectInputStream`和`ObjectOutputStream`：用于存储和读取基本数据类型或对象的处理流。它的强大之处就是可以把`java`的对象写入到数据源中，也能把对象从数据源中还原回来
- 序列化：用`ObjectOutputStream`类保存接本类型数据或对象的机制
- 反序列化：用`ObjectInputStream`类读取基本数据类型或对象的机制
- `ObjectOutputStream`和`ObjectInputStream`不能序列化`static`和`transient`修饰的成员变量 

**对象流的序列化**

1. 创建对象流

   ```java
   ObjectOutputStream new ObjectOutputStream(new FileOutputStream("object.dat"));
   ```

2. 写入对象并刷新缓冲区

   ```java
   oos.writeObject(new String("hello 中国"));
   oos.flush();
   ```

3. 关闭流

   ```java
   oos.close();
   ```

4. 异常处理

   ```java
   @Test
   public void test(){
       ObjectOutputStream oos = null;
       try {
           oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
           oos.writeObject(new String("hello 中国"));
           oos.flush();
   
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
           if (oos != null)
           	oos.close();
           } catch (IOException e) {
           	e.printStackTrace();
       	}
   	}
   }
   ```

**对象流的反序列化**

1. 创建对象流

   ```java
   ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
   ```

2. 反序列化

   ```java
   String str = (String) ois.readObject();
   System.out.println(str);
   ```

3. 关闭流

   ```java
   ois.close();
   ```

4. 异常处理

   ```java
   @Test
   public void test1(){
       ObjectInputStream ois = null;
       try {
           ois = new ObjectInputStream(new FileInputStream("object.dat"));
           String str = (String) ois.readObject();
           System.out.println(str);
       } catch (IOException e) {
       	e.printStackTrace();
       } catch (ClassNotFoundException e) {
       	e.printStackTrace();
       } finally {
           try {
           if (ois != null)
           	ois.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
       }
   }
   ```

**序列化的要求**

- 如果需要让某个对象支持序列化的，则必须让对象所属的类及其属性是可序列化(基本数据库类型默认可序列化)的，为了让某个类是可序列化的，该类必须实现如下两个接口之一

  ```java
  Serializable
  Externalizable
  ```

- 并且提供一个序列化版本号

  ```java
  public static final long serialVersionUID = 498464161223L;
  ```

- 序列化实例

  ```java
  class Person implements Serializable{
      private String name;
      private int age;
      public static final long serialVersionUID = 498464161223L;
  
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
      @Override
      public String toString() {
          return "Person{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

- 凡是实现`Serializable`接口的类都有一个表示序列化版本标识符的静态变量

  `private static final long serivalVersionUID`

  `seralVersionUID`用来表明类的不同版本间的兼容性，简言之，其目的是以序列化对象进行版本控制，有关个版本反序列化时是否兼容

  如果类没有显示定义这个静态常量，它的值是`java`运行时环境根据类的内部细节自动生成的。若类的实例变量做了修改，`serivalVersionUID`可能发生变化

- 简单来说，`java`序列化机制是通过在运行时判断类的`serialVersionUID`来验证版本一致性的。在进行反序列化时，`JVM`会把传来的字节流中的`serialVersionUID`与本地相应实体类的`serialVersionUID`进行比较，如果相同就认为是一直的，可以进行反序列化，否则就会出现序列化版本不一致的异常

#### 6.8.5 随机存取文件流

`RandomAccessFile`类

- `RandomAccessFile`声明在`java.io`包下，但直接继承于`java.lang.Object`类。并且用它实现了`DataInput`、`DataOutput`这两个接口，也就意味着这个类即可以读也可以写

- `RandomAccessFile`类支持"随机访问"的方式，程序可以直接跳到文件的任意地方来读、写文件

  支持只访问文件的部分内容

  可以向已存在的文件后追加内容

- `RandomAccessFile`类对象可以自由移动记录指针

  `long getFilePointer()`：获取文件记录指针的当前位置

  `void seek(long pos)`：将文件记录指针定位到`pos`位置

- 构造器

  ```java
  public RandomAccessFile(File file, String mode)
  public RandomAccessFile(String name, String mode)
  ```

- 创建`RandomAccessFile`类实例需要指定一个`mode`参数，该参数指定`RandomAccessFile`的访问模式

  `r`：以只读方式打开

  `rw`：打开以便读取和写入

  `rwd`：打开以便读取和写入：同步文件内容的更新

  `rws`：打开以便读取和写入：同步文件内容和元数据的更新

- 如果模式为只读`r`。则不会创建文件，而是会去读取一个已经存在的文件，如果读取的文件不存在则会出现异常。如果模式为`rw`读写。如果文件不存在则会去创建文件，如果存在则不会创建

**文件复制实例**

```java
@Test
public void test(){

    RandomAccessFile rafr = null;
    RandomAccessFile rafrw = null;
    try {
        rafr = new RandomAccessFile("hello.txt", "r");
        rafrw = new RandomAccessFile("hello1.txt", "rw");

        byte[] buffer = new byte[1024];
        int len;
        while(true){
            if (((len = rafr.read(buffer)) != -1)) {
                rafrw.write(buffer, 0, len);
            }
        }
    } catch (IOException e) {
    	e.printStackTrace();
    } finally {
        try {
            if (rafr != null)
            	rafr.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        try {
            if (rafrw != null)
            	rafrw.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
```

`RandomAccessFile`默认是覆盖原有文件位置的内容(不是覆盖所有)

可以设置从文件指定位置开始写入或者读取文件(重定向文件指针)

```java
void seek(long pos)
```

### 6.9 NIO

- `Java NIO`：与原本的`IO`有同样的作用和目的，但是使用的方式完全不同，`NIO`支持面相缓冲区的(`IO`是面相流的)、基于通道的`IO`操作

- `NIO`有两种，一种针对标准输入输出`NIO`,另一套网络编程`NIO`

  ```mermaid
  graph TD
  A[java.nio.channels.Channel] --> FileChannel:本地文件
  A --> SocketChannel:Tcp客户端
  A --> ServerSocketChannel:Tcp服务端
  A --> DatagramChannel:UDP发送端和接受端
  ```

- `NIO2`引入`Path`接口，代表一个和平台无关的平台路径，描述了目录中文件的位置。`Path`是`File`类的升级版，实际引用的资源可以不存在

  ```java
  import java.nio.file.Path;
  import java.nio.file.Paths;
  Path path = Paths.get("hello.txt");
  ```

- `NIO2`中还有`Paths`和`Files`工具类，提供了一系列的文件目录操作方法

### 6.9 字符集

编码表：计算机只能识别二进制数据，早起由来是电信号。为了方便应用计算机，让他可以识别各个国家的文字。就将各个国家的文件使用数字来表示，并一一对应，形成一张表为编码表

常见的编码表

- `ASCII`：美国标准信息交换码，用一个字节的7位可以表示
- `ISO8859-1`：拉丁码表，欧洲码表，用一个字节的8位表示
- `GB2312`：中国的中文编码表。两个字节编码所有字符
- `GBK`：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
- `Unicode`：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码，所有的文字都用两个字节来表示
- `UTF-8`：变长的编码方式，可用`1-4`个字节来表示一个字符

## 7. 网络编程

### 7.1 概述

- `java`是`Internet`上的语言，他从语言级上提供了对网络应用程序的支持，程序员能够很容易开发常见的网络应用程序
- `java`提供的网络类库，可以安装无痛的网络连接，联网的底层细节被隐藏在`java`的本机安装系统里，由`JVM`进行控制。并且`java`实现了一个跨平台的网络库，程序员面对的是一个统一的网络编程环境

#### 7.1.1 IP

`java`中使用`InetAddress`类代表`IP`

方式一：`IP`地址表示

```java
public static void main(String[] args) {
    InetAddress inetAddress = null;
    try {
    	inetAddress = InetAddress.getByName("192.168.1.1");
    } catch (UnknownHostException e) {
    	e.printStackTrace();
    }
    System.out.println(inetAddress); // /192.168.1.1
}
```

方式二：域名表示

```java
public static void main(String[] args) {
    InetAddress inetAddress = null;
    try {
        inetAddress = InetAddress.getByName("www.baidu.com");
    } catch (UnknownHostException e) {
    	e.printStackTrace();
    }
    System.out.println(inetAddress); // www.baidu.com/39.156.66.18
}
```

#### 7.1.2 端口号

端口号标识正在计算机上运行的进程

- 不同的进程有不同的端口号

- 被规定为一个`16`位的整数`0~65535`

- 端口分类

  公认端口：`0~1023`，被预先定义的服务通信占用。`HTTP`,80、`FTP`,21、`Telnet`,23

  注册端口：`1024~49151`，分配给用户进程或应用程序。`Tomcat`,8080、`MySQL`,3306、`Oracle`,1521

  动态/私有端口：`49152~65535`

- 端口号与`IP`地址的组合得出一个网络套接字`Socket`

#### 7.1.3 网络协议

- 网络通信协议：计算机网络中实现通信必须有一些约定，即通信协议，对速率、传输代码、代码结构、传输控制步骤、出错控制等指定标准
- 网络协议太复杂：计算机网络通信涉及内容很多，比如指定源地址和目标地址，加密解密，压缩解压缩，差错控制，流量控制，路由控制
- 通信协议分层的思想：在制定协议时，把复杂成份分解成一些简单的成份，再将它们复合起来。最常用的复合方式是层次关系，即同层间可以通信、上一层可以调用下一层，而与再下一层不发生关系。各层互不影响，利于系统的开发和扩展

**`TCP/IP`协议簇**

- 传输层协议中有两个非常重要的协议

  传输控制协议`TCP`

  用户数据协议`UDP`

- `TCP/IP`以其两个主要协议：传输控制协议`TCP`和网络互联协议`IP`而得名，实际上是一组协议，包括多个具有不同功能且互为关联的协议

- `IP`协议是网络层的主要协议，支持网间互联的数据通信

- `TCP/IP`协议模型从更实用的角度出发，形成了高效的四层体系结构，即物理链路层、`IP`层、传输层和应用层

### 7.2 TCP网络编程

#### 7.2.1 客户端

1. 获取服务端`IP`

   ```java
   InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
   ```

2. 获取套接字

   ```java
   Socket socket = new Socket(inetAddress, 8080);
   ```

3. 获得输出流

   ```java
   OutputStream os = socket.getOutputStream();
   ```

4. 写入信息

   ```java
   os.write("Hello, I am a client".getBytes());
   ```

5. 关闭数据的输出，提示服务器数据传送完毕

   ```java
   socket.shutdownOutput(); 
   ```

6. 接受服务端的反馈

   ```java
   InputStream inputStream = socket.getInputStream();
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   byte[] message = new byte[1024];
   int len;
   while((len = inputStream.read(message)) != -1) {
   	baos.write(message, 0, len);
   }
   System.out.println(baos.toString());
   ```

7. 关闭流和套接字

   ```java
   os.close();
   socket.close();
   ```

8. 异常处理

   ```java
   @Test
   public void client(){
       InetAddress inetAddress = null;
       Socket socket = null;
       OutputStream os = null;
       InputStream inputStream = null;
       ByteArrayOutputStream baos = null;
   
       try {
           inetAddress = InetAddress.getByName("127.0.0.1");
           socket = new Socket(inetAddress, 8080);
   
           os = socket.getOutputStream();
           os.write("Hello, I am a client".getBytes());
           
           socket.shutdownOutput();
   
           inputStream = socket.getInputStream();
           baos = new ByteArrayOutputStream();
           byte[] message = new byte[1024];
           int len;
           while((len = inputStream.read(message)) != -1) {
               baos.write(message, 0, len);
           }
           System.out.println(baos.toString());
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (inputStream != null)
                   inputStream.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {
               if (baos != null)
                   baos.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           
           try {
               if (os != null)
               	os.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
           try {
               if (socket != null)
               	socket.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
       }
   }
   ```

#### 7.2.2 服务端

1. 创建服务器套接字

   ```java
   ServerSocket serverSocket = new ServerSocket(8080);
   ```

2. 接受客户端的`Socket`

   ```java
   Socket socket = serverSocket.accept();
   ```

3. 获得输入流

   ```java
   InputStream inputStream = socket.getInputStream();
   ```

4. 读取信息

   ```java
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   byte[] message = new byte[1024];
   int len;
   while((len = inputStream.read(message)) != -1) {
       baos.write(message, 0, len);
   }
   System.out.println(baos.toString());
   ```

5. 服务器给予客户端反馈

   ```java
   OutputStream outputStream = socket.getOutputStream();
   outputStream.write("I am a server".getBytes());
   ```

6. 关闭流和套接字

   ```java
   baos.close();
   inputStream.close();
   socket.close();
   serverSocket.close();
   ```

7. 异常处理

   ```java
   @Test
   public void server(){
       // 服务端
       ServerSocket serverSocket = null;
       Socket socket = null;
       InputStream inputStream = null;
       ByteArrayOutputStream baos = null;
       OutputStream outputStream = null;
       try {
           serverSocket = new ServerSocket(8080);
           socket = serverSocket.accept();
           inputStream = socket.getInputStream();
   
           baos = new ByteArrayOutputStream();
           byte[] message = new byte[1024];
           int len;
           while((len = inputStream.read(message)) != -1) {
           	baos.write(message, 0, len);
           }
           System.out.println(baos.toString());
           
           outputStream = socket.getOutputStream();
           outputStream.write("I am a server".getBytes());
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           try {
               if (outputStream != null)
                   outputStream.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {
               if (baos != null)
               	baos.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
           try {
           	if (inputStream != null)
           		inputStream.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
           try {
           	if (socket != null)
           		socket.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
           try {
           	if (serverSocket != null)
           		serverSocket.close();
           } catch (IOException e) {
           	e.printStackTrace();
           }
       }
   }
   ```

### 7.3 UDP网络编程

#### 7.3.1 发送端

1. 创建套接字

   ```java
   DatagramSocket socket = new DatagramSocket();
   ```

2. 创建数据包

   ```java
   String str = "我是UDP方式发送的数据包";
   InetAddress inet = InetAddress.getLocalHost();
   DatagramPacket packet = new DatagramPacket(str.getBytes(), 0, str.length(), inet, 8080);
   ```

3. 发送数据包

   ```java
   socket.send(packet);
   ```

4. 关闭资源

   ```java
   socket.close();
   ```

5. 异常处理

   ```java
   @Test
   public void send(){
       DatagramSocket socket = null;
       try {
           socket = new DatagramSocket();
   
           String str = "我是UDP方式发送的数据包";
           InetAddress inet = InetAddress.getLocalHost();
           DatagramPacket packet = new DatagramPacket(str.getBytes(), 0, str.length(), inet, 8080);
   
           socket.send(packet);
   
       } catch (IOException e) {
       	e.printStackTrace();
       } finally {
           if (socket != null)
           	socket.close();
       }
   }
   ```

#### 7.3.2 接收端

1. 创建套接字

   ```java
   DatagramSocket socket = new DatagramSocket(8080);
   ```

2. 创建接受的数据包

   ```java
   byte[] buffer = new byte[100];
   DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
   ```

3. 接受数据

   ```java
   socket.receive(packet);
   ```

4. 输出数据

   ```java
   System.out.println(new String(packet.getData(), 0, packet.getLength()));
   ```

5. 关闭资源

   ```
   socket.close();
   ```

6. 异常异常处理

   ```java
   @Test
   public void receiver() {
       // 创建套接字
       DatagramSocket socket = null;
       try {
           socket = new DatagramSocket(8080);
   
           // 创建接受的数据包
           byte[] buffer = new byte[1024];
           DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
   
           // 接受数据
           socket.receive(packet);
   
           // 输出数据
           System.out.println(new String(packet.getData(), 0, packet.getLength()));
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if(socket != null)
               socket.close();
       }
   }
   ```

### 7.4 URL编程

- `URL(Uniform Resource Locator)`：统一资源定位符，它表示`internet`上某一资源的地址

- 它是一种具体的`URL`，即`URL`可以用来标识一个资源，而且还指明了如何`locate`这个资源

- 通过`URL`我们可以访问`internet`上的各种网络资源，比如常见的`www`，`ftp`站点。浏览器通过解析给定的`URL`可以在网络上查找相应的文件或其它资源

- `URL`的基本结构由5部分组成

  ```java
  <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
  ```

- 实例化

  ```java
  URL url = new URL("https://www.baidu.com/");
  ```

- 常用方法

  `String getProtocol()`获取协议名

  ```java
  System.out.println(url.getProtocol()); // https
  ```

  `String getPort()`获取该URL的端口号

  ```java
  System.out.println(url.getPort()); // -1
  ```

  `String getPath()`获取该URL的文件路径

  ```java
  System.out.println(url.getPath()); // /
  ```

## 8. java反射机制

### 8.1 反射机制概述

- `Reflection`(反射)被视为动态语言的关键，反射机制允许程序在执行期间借助于`Reflection API`取得任何类的内部信息，并能直接操作任意对象的内部属性和方法。

- 加载完类之后，在堆内存的方法区中就产生了一个`Class`类型的对象(一个类只有一个`Class`对象)，这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。

- `java`反射机制提供的功能

  在运行时判断任意一个对象所属的类

  在运行时构造任意一个类的对象

  在运行时判断任意一个类所具有的成员变量和方法

  在运行时获取泛型信息

  在运行时调用任意一个对象的成员变量和方法

  在运行时处理注解

  生成动态代理

- 反射的相关`API`

  ```java
  java.lang.Class; // 代表一个类
  java.lang.reflect.Method; // 代表类的方法
  java.lang.reflect.Field; // 代表类的成员变量
  java.lang.reflect.Constructor; // 代表类的构造器
  ```

#### 8.1.1 快速入门

**Person结构**

```java
class Person{
    private String name;
    public int age;

    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("I am " + name);
    }

    private String showMessage(String nation) {
        System.out.println("My nation is " + nation);
        return nation;
    }
}
```

- 通过反射创建`Person`实例

  ```java
  // 拿到Person的class
  Class<Person> personClass = Person.class;
  // 得到Person的构造器
  Constructor<Person> cons = personClass.getConstructor(String.class, int.class);
  // 实例化Person对象
  Person p = cons.newInstance("Tom", 12);
  ```

- 通过反射调用对象指定的属性方法

  ```java
  // 通过反射调用对象指定的属性方法
  Field age = personClass.getField("age");
  age.set(p, 10);
  
  // 调用方法
  Method show = personClass.getMethod("show");
  show.invoke(p);
  ```

- 通过反射也可以调用私有结构

  ```java
  // 调用私有结构器
  Constructor<Person> cons1 = personClass.getDeclaredConstructor(String.class);
  cons1.setAccessible(true);
  Person p2 = cons1.newInstance("大黄");
  // 调用私有的属性
  Field name = personClass.getDeclaredField("name");
  name.setAccessible(true);
  name.set(p2, "大白");
  // 调用私有方法
  Method showNation = personClass.getDeclaredMethod("showNation", String.class);
  showNation.setAccessible(true);
  String nation = (String) showNation.invoke(p2, "China");
  System.out.println(p2);
  ```

#### 8.1.2 Class类

`Class`类的实例对应着一个运行时类

**获取`Class`实例的方式**

- 方式一：调用运行时类的属性

  ```java
  Class<Person> clazz = Person.class;
  System.out.println(clazz);
  // class ReflectionTest.Person
  ```

- 方式二：通过运行时类的对象，调用`getClass()`

  ```java
  Person p = new Person();
  Class clazz = p1.getClass();
  System.out.println(clazz);
  // class ReflectionTest.Person
  ```

- 方式三：调用`Class`的静态方法：`forName(String classPath)`

  ```java
  Class clazz = Class.forName("ReflectionTest.Person");
  System.out.println(clazz);
  // class ReflectionTest.Person
  ```

- 方式四：使用类的加载器

  ```java
  ClassLoader classLoader = ReflectionTest.class.getClassLoader();
  Class clazz = classLoader.loadClass("ReflectionTest.Person");
  System.out.println(clazz);
  // class ReflectionTest.Person
  ```

**`Class`类对应的对象**

- `class`：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
- `interface`：接口
- `[]`：数组
- `enum`：枚举
- `annotation`：注解`@interface`
- `primitive type`：基本数据类型
- `void`

### 8.2 创建运行时类的对象

`newInstance()`：调用此方法，创建对应的运行时类的对象，调用对应类的空参构造器

```java
Class<Person> clazz = Person.class;
Person p = clazz.newInstance(); // 方法已过时，推荐clazz.getConstructor().newInstance();
System.out.println(p); // Person{name='null', age=0}
```

提供创建多个类实例的方法

```java
public Object getInstance(String classPath) throws Exception {
	return Class.forName(classPath).getConstructor().newInstance();
}
```

实例调用

```java
int num = new Random().nextInt(3);
String classPath = "";
switch(num) {
    case 1:
        classPath = "java.util.Date";
        break;
    case 2:
        classPath = "java.lang.Object";
        break;
    default:
    	classPath = "ReflectionTest.Person";
}
try {
	Object obj = getInstance(classPath);
	System.out.println(obj);
} catch (Exception e) {
	e.printStackTrace();
}
```

### 8.3 获取运行时类的完整结构

#### 8.3.1 类的结构

`Person.java`

```java
import java.util.Random;

@MyAnnotation(value = "class")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){
        id = new Random().nextInt(100);
    }

    @MyAnnotation(value = "constructor")
    private Person(String name) {
        this();
        this.name = name;
    }

    Person(String name, int age) {
        this(name);
        this.age = age;
    }

    @MyAnnotation(value = "method")
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String skill(String skill) throws Exception {
        return skill;
    }
    @Override
    public int compareTo(String o) {
        return name.compareTo(o);
    }
	private static void showDesc() {
        System.out.println("我是 static method");
    }
    @Override
    public void info() {
        System.out.println("I am a Person");
    }
}
```

`Creature.java`

```java
import java.io.Serializable;

public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
```

`MyInterface.java`

```java
package reflectstruct;

public interface MyInterface {
    void info();
}
```

`MyAnnotation.java`

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
```

#### 8.3.2 获取属性结构

- `Field[] getFields()`：获取当前运行时类及其父类中声明为`public`的属性

  ```java
  Field[] fields = clazz.getFields();
  for(Field f : fields) {
  	System.out.println(f);
  }
  // public int reflectstruct.Person.id
  // public double reflectstruct.Creature.weight
  ```

- `Field[] getDeclaredFields()`：获取当前运行时类中声明的所有属性和方法(不包含父类)

  ```java
  Field[] fields = clazz.getDeclaredFields();
  for(Field f : fields) {
  	System.out.println(f);
  }
  // private java.lang.String reflectstruct.Person.name
  // int reflectstruct.Person.age
  // public int reflectstruct.Person.id
  ```

- 对于每个属性也可以获得以下结构
  
```java
  Class<Person> clazz = Person.class;
  Field[] fields = clazz.getDeclaredFields();
```

  `int getModifiers()`：获取权限修饰符，为一个整数，调用`Modifier.toString(int mod)`转换为`String`字符串

  ```java
  for(Field f : fields) {
      int modifiers = f.getModifiers();
    System.out.println(Modifier.toString(modifiers));
  }
  // private
  //
  // public
  ```

  `Class<?> getType()`：获取变量的类型

  ```java
  for(Field f : fields) {
      Class type = f.getType();
      System.out.println(type);
  }
  // class java.lang.String
  // int
  // int
  ```

  `public String getName() `：获取变量名

  ```java
  for(Field f : fields) {
      String name = f.getName();
      System.out.println(name);
  }
  // name
  // age
  // id
  ```

#### 8.3.3 获取方法结构

- `Method[] getMethods()`：获取当前运行时类及其所有父类中声明为`public`权限的方法

  ```java
  @Test
  public void test() {
      Class<Person> clazz = Person.class;
      Method[] methods = clazz.getMethods();
  
      for(Method m : methods) {
      	System.out.println(m);
      }
  }
  ```

  ```java
  // public java.lang.String reflectstruct.Person.skill(java.lang.String)
  // public int reflectstruct.Person.compareTo(java.lang.Object)
  // public int reflectstruct.Person.compareTo(java.lang.String)
  // public void reflectstruct.Person.info()
  // public void reflectstruct.Creature.eat()
  // public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
  // public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
  // public final void java.lang.Object.wait() throws java.lang.InterruptedException
  // public boolean java.lang.Object.equals(java.lang.Object)
  // public java.lang.String java.lang.Object.toString()
  // public native int java.lang.Object.hashCode()
  // public final native java.lang.Class java.lang.Object.getClass()
  // public final native void java.lang.Object.notify()
  // public final native void java.lang.Object.notifyAll()
  ```

- `Method[] getDeclaredMethods()`：获取当前类的所有属性和方法

  ```java
  Method[] declaredMethods = clazz.getDeclaredMethods();
  for(Method m : declaredMethods) {
  	System.out.println(m);
  }
  // public int reflectstruct.Person.compareTo(java.lang.String)
  // public int reflectstruct.Person.compareTo(java.lang.Object)
  // public void reflectstruct.Person.info()
  // private java.lang.String reflectstruct.Person.show(java.lang.String)
  // public java.lang.String reflectstruct.Person.skill(java.lang.String)
  ```

- 具体也可以获取权限修饰符，返回值类型，注解

  ```java
  @Test
  public void test() {
      Class<Person> clazz = Person.class;
      Method[] declaredMethods = clazz.getDeclaredMethods();
  }
  ```

  获取方法声明的注解

  ```java
  for(Method m : declaredMethods) {
      Annotation[] annos = m.getAnnotations();
      for(Annotation a : annos) {
          System.out.println(a);
      }
  }
  // @reflectstruct.MyAnnotation(value="method")
  ```

  `int getModifiers()`：获取权限修饰符

  ```java
  for(Method m : declaredMethods) {
      System.out.println(Modifier.toString(m.getModifiers()));
  }
  // private
  // public
  // public volatile
  // public
  // public
  ```

  `Class<?> getReturnType()`：获取返回值

  ```java
  for(Method m : declaredMethods) {
      System.out.println(m.getReturnType());
  }
  // java.lang.String
  // java.lang.String
  // int
  // int
  // void
  ```

  `String getName()`：获取方法名

  ```java
  for(Method m : declaredMethods) {
  	System.out.println(m.getName());
  }
  // show
  // skill
  // compareTo
  // compareTo
  // info
  ```

  `Class<?>[] getParameterTypes()`：获取形参列表

  ```java
  for(Method m : declaredMethods) {
  	Class[] parameterTypes = m.getParameterTypes();
      	if(parameterTypes != null && parameterTypes.length != 0) {
          	for(Class param : parameterTypes) {
              	System.out.print(param + " ");
              }
          }
  }
  // class java.lang.String
  // class java.lang.String
  // class java.lang.Object
  // class java.lang.String
  //    
  ```

  `Class<?>[] getExceptionTypes()`：获取异常

  ```java
  Class[] exceptions = m.getExceptionTypes();
  if (exceptions != null && exceptions.length != 0) {
      System.out.print("throws ");
      for(Class e : exceptions) {
      	System.out.print(e);
      }
  }
  ```

#### 8.3.4 获取其它结构

```java
@Test
public void test() {
	Class<Person> clazz = Person.class;
}
```

- `Constructor<?>[] getConstructors()`：获取当前类中声明为`public`的构造器

  ```java
  Constructor[] constructors = clazz.getConstructors();
  for(Constructor con : constructors) {
  	System.out.println(con);
  }
  // public reflectstruct.Person()
  ```

- `Constructor<?>[] getDeclaredConstructors()`：获取当前类中所有的构造器

  ```java
  Constructor[] constructors1 = clazz.getDeclaredConstructors();
  for(Constructor con : constructors1) {
  	System.out.println(con);
  }
  // public reflectstruct.Person()
  // reflectstruct.Person(java.lang.String,int)
  // private reflectstruct.Person(java.lang.String)
  ```

- 获取运行时的父类

  ```java
  Class superClass = clazz.getSuperclass();
  System.out.println(superClass);
  // class reflectstruct.Creature
  ```

- 获取运行时类的带泛型的父类

  ```java
  Type superClass1 = clazz.getGenericSuperclass();
  System.out.println(superClass1);
  // reflectstruct.Creature<java.lang.String>
  ```

- 获取运行时类的带泛型的父类的泛型

  ```java
  Type superClass = clazz.getGenericSuperclass();
  ParameterizedType ptt = (ParameterizedType)superClass;
  Type[] args = ptt.getActualTypeArguments();
  for(Type a : args) {
  	System.out.println(a);
  }
  // class java.lang.String
  ```

- ` Class<?>[] getInterfaces()`：获取运行时类实现的接口

  ```java
  Class[] interfaces = clazz.getInterfaces();
  for(Class in : interfaces) {
  	System.out.println(in);
  }
  // interface java.lang.Comparable
  // interface reflectstruct.MyInterface
  ```

- `Package getPackage()`：获取运行时类所在的包

  ```java
  Package pack = clazz.getPackage();
  System.out.println(pack);
  // 	package reflectstruct
  ```

- 获取运行时类的注解

  ```java
  Annotation[] annotations = clazz.getAnnotations();
  for(Annotation annotation : annotations) {
  	System.out.println(annotation);
  }
  // @reflectstruct.MyAnnotation(value="class")
  ```

### 8.4 调用运行时类的指定结构

```java
@Test
public void test3() throws Exception {
    Class<Person> clazz = Person.class;
}
```

#### 8.3.1 属性

**方式一**

- `Field getField(String name)`：获取运行时类的某一个属性,要求运行时类中声明为`public`的属性

  ```java
  Field id = clazz.getField("id");
  System.out.println(id); // public int reflectstruct.Person.id
  ```

- 设置当前属性的值

  ```java
  Person p = clazz.getConstructor().newInstance();
  id.set(p, 1001);
  ```

- 获取当前属性的值

  ```java
  System.out.println(id.get(p));
  // 1001
  ```

:star:**方式二**

- `Field getDeclaredField(String name)`：获取运行时类中的任意属性

  ```java
  Field name = clazz.getDeclaredField("name");
  ```

- 设置当前属性是可访问的

  ```java
  name.setAccessible(true);
  ```

- 设置当前属性的值

  ```java
  name.set(p, "Tom");
  System.out.println(name.get(p));
  // Tom
  ```

#### 8.3.2 方法

**调用普通方法**

- 创建运行时类的对象

  ```java
  Person p = clazz.getConstructor().newInstance();
  ```

- `Method getDeclaredMethod(String name, Class<?>... parameterTypes)`：获取指定的某个方法

  ```java
  Method show = clazz.getDeclaredMethod("show", String.class);
  ```

- 确保方法是可访问的(仅对于访问权限小于`public`的)

  ```java
  show.setAccessible(true);
  ```

- `Object invoke(Object obj, Object... args)`：调用方法并获得返回值

  ```java
  String returnValue = (String)show.invoke(p, "China"); // 我的国籍是：China
  System.out.println(returnValue); // China
  ```

**调用静态方法**

```java
Method showDesc = clazz.getDeclaredMethod("showDesc");
showDesc.setAccessible(true);
showDesc.invoke(Person.class); // 参数也可以是Person对象 null
```

#### 8.3.3 构造器

- 获取指定的构造器

  ```java
  Constructor<Person> pc = clazz.getDeclaredConstructor(String.class);
  ```

- 保证此构造器是可访问的

  ```java
  pc.setAccessible(true);
  ```

- 创建对象

  ```java
  Person tom = pc.newInstance("Tom");
  System.out.println(tom);
  // Person{name='Tom', age=0, id=91}
  ```

### 8.5 动态代理

- 创建接口

  ```java
  interface Human{
      String getBelief();
      void eat(String food);
  }
  ```

- 创建被代理类

  ```java
  class SuperMan implements Human {
  
      @Override
      public String getBelief() {
          return "保护地球";
      }
  
      @Override
      public void eat(String food) {
          System.out.println("超人吃" + food);
      }
  }
  ```

- 创建工厂类

  ```java
  class ProxyFactory{
      // 调用此方法，返回一个代理类对象 obj为被代理类的对象
      public static Object getProxyInstance(Object obj) {
          MyInvocationHandler handler = new MyInvocationHandler();
  
          handler.bind(obj);
  
          return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
      }
  }
  ```

- 创建实现方法的类

  ```java
  class MyInvocationHandler implements InvocationHandler{
      private Object obj; // 需要使用被代理类的对象进行赋值
  
      public void bind(Object obj) {
          this.obj = obj;
      }
      // 当通过代理类的对象，调用方法时，就会自动调用 invoke
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          // method是代理类对象调用的方法，也是被代理类对象要调用的方法
          return method.invoke(obj, args);
      }
  }
  ```

- 测试

  ```java
  public class DynamicProxyTest {
      public static void main(String[] args) {
          Human proxyInstance = (Human)ProxyFactory.getProxyInstance(new SuperMan());
          System.out.println(proxyInstance.getBelief());
          proxyInstance.eat("掉渣饼");
      }
  }
  // 保护地球
  // 超人吃掉渣饼
  ```

## 9. java8新特性

`java8`是`java`语言开发的一个主要版本，是`java5`以来最具有革命性的版本

**特点**

- 速度更快
- 代码更少(增加了新的语法：`Lambda`表达式)
- 强大的`Stream API`
- 便于并行
- 最大化减少空指针异常`Optional`
- `Nashorm`引擎，允许在`JVM`上运行`JS`应用(未来准备弃用)

### 9.1 Lambda表达式

#### 9.1.1 概述

`Lambda`是一个匿名函数，我们可以吧`Lambda`表达式理解是一段可以传递的代码(将代码像数据一样传递)。使用它可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使`java`的语言表达能力得到了提升

```java
(o1, o2) -> Integer.compare(o1, o2);
```

- `->`：`Lambda`表达式的操作符
- `(o1, o2)`：形参列表
- `Integer.compare(o1, o2)`：`Lambda`体

`Lambda`表达式的本质：作为函数式接口的实例

#### 9.1.2 快速入门

```java
@Test
public void test1() {
    Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);

    System.out.println(com.compare(23, 32)); // -1
}
```

#### 9.1.3 基本使用

- 无参，无返回值

  ```java
  Runnable r = () -> System.out.println("I am a iron man");
  r.run(); // I am a iron man
  ```

- 需要一个参数，没有返回值。参数类型可以省略，只有一个参数`()`可以省略

  ```java
  Consumer<String> c = (String str) -> {
  	System.out.println("有一个参数，没有返回值\t" + str);
  };
  c.accept("被调用了");
  // 有一个参数，没有返回值	被调用了
  ```

- 有两个或以上的参数，有多条执行语句，并且可以有返回值

  ```java
  Comparator<Integer> com = (o1, o2) -> {
  	return Integer.compare(o1, o2);
  };
  
  System.out.println(com.compare(23, 32)); // -1
  ```

### 9.2 函数式接口

#### 9.2.1 概述

- 如果一个接口中，只声明了一个抽象方法，此接口就称为函数式接口
- 可以通过`Lambda`表达式来创建该接口的对象。
- 可以在一个接口上使用`@FunctionalInterface`注解，这样做可以检查它是否是一个函数式接口。同时`javadoc`会包含一条声明，说明这个接口是一个函数式接口
- `java.util.function`包下定义了`java8`的丰富的函数式接口

java内置的函数式接口

|   函数式接口   | 参数类型 | 返回类型 |                             用途                             |
| :------------: | :------: | :------: | :----------------------------------------------------------: |
|  Consumer<T>   |    T     |   void   |       对类型为T的对象应用操作，方法：void accept(T t)        |
|  Supplier<T>   |    无    |    T     |               返回类型为T的对象，方法：T get()               |
| Function<T, R> |    T     |    R     | 对类型为T的对象应用操作，并返回结果。结果是R类型的对象，方法 R apply(T t) |
|  Predicate<T>  |    T     | boolean  | 确定类型为T的对象时否满足约束，并返回boolean值，boolean test(T t) |

#### 9.2.2 消费型接口

```java
 @Test
 public void test() {
     happyTime(500, t -> {
     	System.out.println("我有" + t + "元");
     });
   	// 我有500.0元
 }
 public void happyTime(double money, Consumer<Double> con){
 	con.accept(money);
 }
```

#### 9.2.3 断定型接口

 筛选出所有含 "京" 的字符串

```java
@Test
public void test() {
    List<String> list = Arrays.asList("北京", "上海", "南京","广州", "深圳");

    List<String> list1 = filterString(list, str -> str.endsWith("京"));
    System.out.println(list1);
    // [北京, 南京]
}
public List<String> filterString(List<String> list, Predicate<String> pre) {
    ArrayList<String> filterList = new ArrayList<>();
    for(String s : list) {
        if (pre.test(s)) {
        	filterList.add(s);
        }
    }
    return filterList;
}
```

### 9.3 方法引用

#### 9.3.1 概述

- 当要传递给`Lambda`体的操作，已经有实现的方法了，可以使用方法引用

- 方法引用可以看做是`Lambda`表达式深层次的表达。话句话说，方法引用就是`Lambda`表达式，也就是函数式接口的一个实例，通过方法的名字指向一个方法，可以认为是`Lambda`表达式的一个语法糖

- 要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致

- 格式：使用`::`将类(或对象)与方法名分隔开来

- 如下三种使用情况

  对象::实例方法

  类::静态方法名

  类::实例方法名

#### 9.3.2 具体用法

测试类

```java
public class MethodTest {
}
```

- 对象调用实例方法

  ```java
  @Test
  public void test1() {
      MethodTest methodTest = new MethodTest();
      Supplier<String> sup = methodTest::print;
      System.out.println(sup.get());
  }
  public String print() {
      return "hello";
  }
  ```

- 类调用静态方法

  ```java
  @Test
  public void test2() {
      Comparator<Integer> com = Integer::compare;
      System.out.println(com.compare(12, 3));
  }
  ```

- 类调用实例方法，方法引用的第一个参数和被引用的方法的调用者是相同的

  ```java
  @Test
  public void test3() {
      Comparator<Integer> com = Integer::compareTo;
      System.out.println(com.compare(15, 10));
  }
  ```


### 9.4 构造器与方法引用

#### 9.4.1 构造器引用

```java
class Person{
    private String name;
    private int age;

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

- 调用空参构造器

  ```java
  @Test
  public void test() {
      Supplier<Person> sup = Person::new;
      Person p = sup.get();
      System.out.println(p);
  }
  // Person{name='null', age=0}
  ```

- 调用含参的构造器

  ```java
  @Test
  public void test() {
      BiFunction<String, Integer, Person> bpd = Person::new;
      Person p = bpd.apply("Tom", 18);
      System.out.println(p);
  }
  // Person{name='Tom', age=18}
  ```

#### 9.4.2 数组引用

```java
@Test
public void test() {
    Function<Integer, String[]> func = String[]::new;
    String[] strs = func.apply(5);
    System.out.println(Arrays.toString(strs));
}
// [null, null, null, null, null]
```

### 9.5 Stream API

#### 9.5.1 概述

- `Stream API(java.util.stream)`把真正的函数式编程风格引入`java`中。这是目前为止对`java`类库最好的补充，因为`Stream API`可以极大提供`java`程序员的生产力，让让程序员写出高效率、干净、简洁的代码

- `Stream`是`java8`中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射等操作。使用`Stream API`对集合数据进行操作，就类似于使用`SQL`执行的数据库查询。也可以使用`Stream API`来并行执行操作。简言之，`Stream API`提供了一种高效且易于使用的处理数据的方式 

- `Stream`和`Collection`集合的区别：`Collection`是一种静态的内存数据结构，而`Stream`是有关计算的。前者是主要面对内存，存储在内存中，后者主要是面向`CPU`，通过`CPU`实现计算

- 特点

  `Stream`自己不会存储元素

  `Stream`不会改变源对象。相反，它们会返回一个持有结果的新`Stream`

  `Stream`操作是延迟执行的。这意味着他们会等到需要结果的时候才执行

- `Stream`的操作步骤

  `Stream`的实例化

  一系列的中间操作(过滤、映射)

  终止操作：一旦执行终止操作，之后此`Stream`对象就不能再被使用

`Person`类的结构

```java
class Person{
    private String name;
    private int age;

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<Person> getPersons(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Tom", 18));
        list.add(new Person("Jack", 56));
        list.add(new Person("Alice", 18));
        list.add(new Person("Bob", 38));
        list.add(new Person("Tony", 22));
        list.add(new Person("Stark", 14));
        return list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```



#### 9.5.2 实例化

- 方式一：`java8`中的`Collection`接口被扩展，提供了两个获取流的方法

  首先获取集合对象

  ```java
  List<Person> persons = Person.getPersons();
  ```

  `default Stream<E> stream()`：返回一个顺序流

  ```java
  Stream<Person> stream = persons.stream();
  ```

  `default Stream<E> parallelStream()`：返回一个并行流

  ```
  Stream<Person> personStream = persons.parallelStream();
  ```

- 方式二：通过数组

  `java8`中的`Arrays`的静态方法`stream()`可以获取数组流

  `static <T> Stream<T> stream(T[] array)`：返回一个流

  `Arrays`类提供了一系列的方法用于获取数组流

  `xxxStream stream(xxx[] array)`

  ```java
  int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  IntStream stream = Arrays.stream(arr);
  ```

- 方式三：通过`Stream`的`of()`

  可以调用`Stream`类静态方法`of()`，通过显示值创建一个流。它可以接受任意数量的参数

  ```java
  Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
  ```

- 方式三：创建无限流

  使用静态方法`Stream.iterate()`和`Stream.generate()`，创建无限流

  迭代`static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)`

  ```java
  Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
  ```

  生成`static<T> Stream<T> generate(Supplier<? extends T> s)`

  ```java
  Stream.generate(Math::random).limit(10).forEach(System.out::println);
  ```

#### 9.5.3 中间操作

多个中间操作可以连起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！而在终止操作时一次性全部处理，称为"惰性求值"

**筛选与切片**

| 方法                | 切片                                                         |
| ------------------- | ------------------------------------------------------------ |
| filter(Predicate p) | 接受Lambda,从流中排除某些元素                                |
| distinct()          | 筛选，通过流所生成元素的hashCode()和equals()去除重复元素     |
| limit(long maxSize) | 截断流，使元素不超过给定数量                                 |
| skip(long n)        | 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补 |

- 筛选年龄大于`18`的人

  ```java
  @Test
  public void test() {
  	List<Person> persons = Person.getPersons();
      Stream<Person> stream = persons.stream();
  
      stream.filter(person -> person.getAge() > 20).forEach(System.out::println);
  }
  // Person{name='Jack', age=56}
  // Person{name='Bob', age=38}
  // Person{name='Tony', age=22}
  ```

- 取流的前三条记录

  ```java
  Stream<Person> stream = persons.stream();
  stream.limit(3).forEach(System.out::println);
  // Person{name='Tom', age=18}
  // Person{name='Jack', age=56}
  // Person{name='Alice', age=18}
  ```

- 跳过前三条记录，如果要跳过的数大于总数，返回空

  ```java
  Stream<Person> stream = persons.stream();
  stream.skip(3).forEach(System.out::println);
  // Person{name='Bob', age=38}
  // Person{name='Tony', age=22}
  // Person{name='Stark', age=14}
  ```

**映射**

- 将数组元素转换为大写

  ```java
  @Test
  public void test1() {
      List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
      list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
  }
  // AA
  // BB
  // CC
  // DD
  ```

- 获取员工姓名长度等于4的员工的姓名

  ```java
  List<Person> p = Person.getPersons();
  p.stream().map(Person::getName).filter(name -> name.length() == 4).forEach(System.out::println);
  // Jack
  // Tony
  ```

- `flatMap(Function f)`接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流

  ```java
  List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
  list.stream().flatMap(StreamOperationTest::fromStringToStream).forEach(c -> {
  	System.out.print(c + " ");
  });
  // 将对应字符串中的多个字符构成的集合转化为对应的Stream的实例
  public static Stream<Character> fromStringToStream(String str) {
      ArrayList<Character> list = new ArrayList<>();
      for(Character c : str.toCharArray()) {
          list.add(c);
      }
      return list.stream();
  }
  // a a b b c c d d
  ```

**排序**

```java
@Test
public void test2() {
    List<Integer> list = Arrays.asList(1, 8, 0, 6, 7, 10, 12, 4);
    list.stream().sorted().forEach(num ->{
    	System.out.print(num + " ");
    });
    
    System.out.println();
    
    list.stream().sorted((o1, o2) -> - o1.compareTo(o2)).forEach(num ->{
    	System.out.print(num + " ");
    });
}
// 0 1 4 6 7 8 10 12 
// 12 10 8 7 6 4 1 0
```

#### 9.5.4 终止操作

终止操作会从流的流水线生成结果。其结果可以是任何不是流的值

**匹配与查找**

| 方法                   | 描述                     |
| :--------------------- | :----------------------- |
| allMatch(Predicate p)  | 检查是否匹配所有元素     |
| anyMatch(Predicate p)  | 检查是否至少匹配一个元素 |
| noneMatch(Predicate p) | 检查是否没有匹配所有元素 |
| findFirst()            | 返回第一个元素           |
| findAny()              | 返回当前流中的任意元素   |
| count()                | 返回流中元素总数         |
| max(Comparator c)      | 返回流中最大值           |
| min(Comparator c)      | 返回流中最小值           |
| forEach(Consumer c)    | 内部迭代                 |

- 是否所有人的年龄都大于`18`

  ```java
  public void test() {
      List<Person> list = Person.getPersons();
      boolean flag = list.stream().allMatch(person -> person.getAge() > 18);
      System.out.println(flag); // false
  }
  ```

- 返回第一个人的信息

  ```java
  Optional<Person> p = list.stream().findFirst();
  System.out.println(p);
  // Optional[Person{name='Tom', age=18}]
  ```

- 返回最大的年龄

  ```java
  Optional<Integer> age = list.stream().map(person -> person.getAge()).max(Integer::compare);
  System.out.println(age);
  // Optional[56]
  ```

**归约**

| 方法                             | 描述                                                    |
| -------------------------------- | ------------------------------------------------------- |
| reduce(T iden, BinaryOperator b) | 可以讲流中元素反复结合起来，得到一个值，返回T           |
| reduce(BinaryOperator b)         | 可以讲流中元素反复结合起来，得到一个值。返回Optional<T> |

- 计算`1 - 100`的和

  ```java
  List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  Integer sum = list.stream().reduce(10, Integer::sum);
  System.out.println(sum); // 65
  ```

- 计算所有人的年龄综合

  ```java
  List<Person> person = Person.getPersons();
  Optional<Integer> sum = person.stream().map(Person::getAge).reduce(Integer::sum);
  System.out.println(sum); // Optional[166]
  ```

**收集**

- `collect(Collector c)`：将流转换为其它形式，接受一个`Collector`接口的实现，用于给`Stream`中元素做汇总的方法
- `Collector`接口中方法的实现决定了如何对流执行收集的操作(如：收集到`List`、`Set`、`Map`)
- `Collectors`实用类提供了很多静态方法，可以方便地创建常见收集器实例

- 查找年龄大于20的，结果返回一个List或Set

  ```java
  List<Person> person = Person.getPersons();
  List<Person> list = person.stream().filter(p -> p.getAge() > 18).collect(Collectors.toList());
  System.out.println(list);
  // [Person{name='Jack', age=56}, Person{name='Bob', age=38}, Person{name='Tony', age=22}]
  ```

### 9.6 Optional类

`Optional<T>`类`java.util.Optional`是一个容器类，它可以保存类型`T`的值，代表这个值存在。或仅仅保存`null`，表示这个值不存在。原来用`null`表示一个值不存在，现在`Optional`可以更好的表达这个概念。并且可以避免空指针异常

#### 9.6.1 类的结构

```java
public class Girl {
    private String name;
    public Girl() {}
    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

```java
public class Boy {
    private Girl girl;
    public Boy(){}
    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
```

#### 9.6.2 构造器

- `Optional.of(T t)`：创建一个`Optional`实例，t必须非空

  ```java
  @Test
  public void test() {
      Girl girl = new Girl();
      Optional<Girl> optionalGirl = Optional.of(girl);
  }
  ```

- `Optional<T> ofNullable(T value)`：可以为`null`

  ```java
  @Test
  public void test1() {
      Girl girl = null;
      Optional<Girl> optionalGirl = Optional.ofNullable(girl);
      System.out.println(optionalGirl);
  }
  ```

#### 9.6.3 具体使用

```java
public String getGirlName(Boy boy) {
    Optional<Boy> optionalBoy = Optional.ofNullable(boy);
    Boy boy1 = optionalBoy.orElse(new Boy(new Girl("Alice")));

    Girl girl = boy1.getGirl();
    Optional<Girl> girlOptional = Optional.ofNullable(girl);

    Girl girl1 = girlOptional.orElse(new Girl("Anna"));

    return girl1.getName();
}
```

## 10. JDK9&10&11