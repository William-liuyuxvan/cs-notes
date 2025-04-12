 ## 概述

一个进程多个线程

**进程**是系统资源分配的单位

**线程**是CPU调度和执行的单位



## 1. 继承Thread

==注意==：不能直接用 .run() 方法，这样是直接调用的方法，而不是启动线程，仍然调用的是主方法中的资源。**应该使用 .start()**

```java
public class TestThead extends Thread {
    @Override
    public void run() {
        // run 方法体
        for (int i = 0; i < 20; i++) {
            System.out.println("run : " + i);
        }
    }

    public static void main(String[] args) {
        // 启动线程
        new TestThead().start();

        // 注意：不能使用 .run  这样是调用方法，使用的主线程中的资源
//        new TestThead().run();

        // 主方法
        for (int i = 0; i < 20; i++) {
            System.out.println("main : " + i);
        }
    }
}
```



## 2. 实现Runnable接口

new Thread(new {实现了Runnable接口的类}(参数...)).start();

```java
public class TestRunnable implements Runnable{

    private String url;
    private String fileName;

    public TestRunnable(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
            WebDownloader.downloadFromURLToFile(url, fileName);
    }

    public static void main(String[] args) {
        new Thread(new TestRunnable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "/base/src/com/base/thread/one/7.png")).start();
    }
}

class WebDownloader {

    public static void downloadFromURLToFile(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
            System.out.println(new File(fileName).getAbsolutePath());
            System.out.println("SUCCESS");
        } catch (IOException e) {
            System.out.println("FAILURE");
            throw new RuntimeException(e);
        }
    }
}
```



**总结**：

- 不建议继承Thread类，由于java只能单继承，避免OOP单继承局限性。
- 建议实现Runnable接口，灵活方便，方便同一个对象被多个线程使用。



## 3. 并发问题

线程不安全，多个线程访问同一数据时出现数据紊乱。

```java
// 线程并发问题不安全，多个线程访问同一数据时不安全。
public class TestThreadDemo02 implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        while (ticket-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + ticket);
        }
    }

    public static void main(String[] args) {
        TestThreadDemo02 test = new TestThreadDemo02();

        new Thread(test, "老师").start();
        new Thread(test, "学生").start();
        new Thread(test, "黄牛").start();
        // 访问同一数据
        /*
        老师 : 7
        黄牛 : 7
        学生 : 7
        黄牛 : 5
        黄牛 : 3
        老师 : 6
        黄牛 : 2
        学生 : 4
        黄牛 : 0
        老师 : 1
         */
    }
}
```



## 案例：

案例：龟兔赛跑-Race
1.首先来个赛道距离，然后要离终点越来越近
2.判断比赛是否结束
3.打印出胜利者
4.龟兔赛跑开始
5.故事中是乌龟赢的，兔子需要睡觉，所以我们来模拟兔子睡觉
6.终于，乌龟赢得比赛

```java
// 模拟龟兔赛跑
public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            if (Thread.currentThread().getName().equals("龟") && i % 20 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (i == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者：" + winner);
                break;
            }

            if (winner != null) break;

            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "龟").start();
    }
}
```



## 4. 实现Callable接口

~~~bash
1.实现Callable接口，需要返回值类型
2.重写call方法，需要抛出异常
3.创建目标对象
4.创建执行服务：ExecutorServiceser ser = Executors.newFixedThreadPool(1);
5.提交执行：Future<Boolean> result1 = ser.submit(t1);
6.获取结果：boolean r1 = result1.get();
7.关闭服务：ser.shutdownNow();
~~~

```java
public class TestCallable implements Callable<Boolean> {


    private String url;
    private String fileName;

    public TestCallable(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public Boolean call() {
        WebDownloader2.downloadFromURLToFile(url, fileName);
        System.out.println("下载完成：" + fileName);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "base/src/com/base/thread/one/1.png");
        TestCallable t2 = new TestCallable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "base/src/com/base/thread/one/2.png");
        TestCallable t3 = new TestCallable("https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34905050930/6160/8991/0f0f/85d4094a013dc7c0709fd198152ee9f7.png", "base/src/com/base/thread/one/3.png");

        // 1. 创建执行服务
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 2. 提交执行
        Future<Boolean> submit1 = pool.submit(t1);
        Future<Boolean> submit2 = pool.submit(t2);
        Future<Boolean> submit3 = pool.submit(t3);

        // 3. 获取结果
        boolean b1 = submit1.get();
        boolean b2 = submit2.get();
        boolean b3 = submit3.get();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        // 4. 关闭服务
        pool.shutdownNow();
    }
}

class WebDownloader2 {

    public static void downloadFromURLToFile(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
            System.out.println(new File(fileName).getAbsolutePath());
            System.out.println("SUCCESS");
        } catch (IOException e) {
            System.out.println("FAILURE");
            throw new RuntimeException(e);
        }
    }
}
```



## 5. 静态代理

优点：

- 代理对象可以做真实对象做不到的事情
- 真实对象专注自己的事情 

```java
public class StaticProxy {

    public static void main(String[] args) {
        new MarryCompany(new You("15")).HappyMarry();
    }

}

interface Marry {
    void HappyMarry();
}

class You implements Marry {

    private String name;

    public You(String name) {
        this.name = name;
    }

    @Override
    public void HappyMarry() {
        System.out.println("今天" + name + "要结婚啦！");
    }
}

class MarryCompany implements Marry {

    private You target;

    public MarryCompany(You target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后，付尾款");
    }

    private void before() {
        System.out.println("结婚前，布置现场");
    }
}
```



## 6. Lambda表达式

Function Interface（）函数式接口

函数式接口定义：

- 一个接口，如果只包含唯一一个抽象方法，就是函数式接口
- 对于函数是接口，可以通过lambda表达式来创建该接口对象。

```java
public class TestLambda {
    public static void main(String[] args) {
        Test t = System.out::println;
        t.lambda("haha");
    }
}

interface Test {
    void lambda(String msg);
}
```

==注意==：

- Lambda **表达式**和**方法引用**的使用场景以及函数式接口的定义不同。表达方法和写法不同。



## 7. 线程状态

五大状态

![thread01](E:\notes\img\thread01.png)

![thread02](E:\notes\img\thread02.png)

方法：

1. setPriority(int newPriority)：更改线程的优先级
2. static void sleep(long millis)：在指定的毫秒数内让当前正在执行的线程休
3. void join()：等待该线程终止
4. static void yield()：暂停当前正在执行的线程对象，并执行其他线程
5. void interrupt()：中断线程，**别用**这个方式
6. boolean isAlive()：测试线程是否处于活动状态

### 7.1 停止线程

不建议使用jdk中的 destory() 或 stop()，最好使用**标志位**使线程自己停下来。

```java
public class ThreadStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run......" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();
        new Thread(threadStop).start();

        for (int i = 0; i < 1000; i++) {
            if (i == 500) {
                threadStop.stop();
                System.out.println("run........stop");
            }
            System.out.println("main....." + i);
        }
    }
}
```



### 7.2 线程休眠 - sleep

- sleep（时间）指定当前线程阻塞的毫秒数；
- sleep存在异常InterruptedException;
- sleep时间达到后线程进入就绪状态；
- sleep可以模拟网络延时，倒计时等。
- **每一个对象都有一个锁，sleep不会释放锁;**

 **好处**：

1. 模拟网络延时：放大错误，方便查找
2. 模拟倒计时

```java
// 获取当前时间，倒计时
public class GetCurrentTime {

    public static void main(String[] args) throws InterruptedException {

        // 一 十秒钟倒计时
        tenDown();

        // 二 获取当前时间
        Date date = null;
        int count = 10;
        while (count-- > 0) {
            date = new Date(System.currentTimeMillis());
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            Thread.sleep(1000);
        }
    }

    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (num-- > 0) {
            System.out.println(num);
            Thread.sleep(1000);
        }
    }
}
```



### 7.3 线程礼让 - yield

- 让当前正在执行的线程暂停，但不阻塞
- 将线程从运行状态转变为就绪状态
- 重新竞争执行顺序 --> 由CPU调度



### 7.4 线程强制执行 - join

- 插队 --- 强制执行线程，其他线程阻塞

```java
public class ThreadJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run ..... " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadJoin());
        thread.start();

        for (int i = 0; i < 20; i++) {
            if (i == 5) {
                thread.join();
            }
            Thread.sleep(500);
            System.out.println("main...." + i);
        }
    }
}
```



### 7.5 五大状态检测 - Thread.State

- NEW
  尚未启动的线程处于此状态。
- RUNNABLE
  在Java虚拟机中执行的线程处于此状态。
- BLOCKED
  被阻塞等待监视器锁定的线程处于此状态。
- WAITING
  正在等待另一个线程执行特定动作的线程处于此状态。
- TIMED WAITING
  正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。
- TERMINATED
  已退出的线程处于此状态。

```java
public static void main(String[] args) throws InterruptedException {

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("-------------");
        }
    });

    Thread.State state = thread.getState();
    System.out.println(state);

    thread.start();
    state = thread.getState();
    System.out.println(state);

    while (state != Thread.State.TERMINATED) {
        Thread.sleep(200);
        state = thread.getState();
        System.out.println(state);
    }
}
```



### 7.6 线程优先级

- Java提供一个线程调度器来监控程序中启动后进入就绪状态的所有线程，线程调度器按照优先级决定应该调度哪个线程来执行。
- 线程的优先级用数字表示，范围从1～10.
  - Thread.MIN_PRIORITY = 1;
  - Thread.MAX_PRIORITY = 10;
  - Thread.NORM_PRIORITY = 5;
- **优先级低只是意味着获得调度的概率低.并不是优先级低就不会被调用了.这都是看CPU的调度**
- 使用以下方式改变或获取优先级
  - getPriority() . setPriority(int xxx)
  - **优先级的设定建议在 start() 调度前**



## 8. 守护线程 - daemon

- 线程分为**用户线程**和**守护线程**
- 虚拟机**必须确保用户线程**执行完毕 -- main()
- 虚拟机**不必等待守护线程**执行完毕 -- gc()
- 如：后台记录日志、监控内存、垃圾回收等待。

```java
// deamon 默认是 false --> 既是默认用户线程
// 虚拟机确保了用户线程的正常执行，执行结束后便正常关闭，守护线程随着程序（用户线程）的结束而结束。
public class ThreadDaemon {
    public static void main(String[] args) {
        God god = new God();
        People people = new People();

        // 设置守护线程
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);
        godThread.start();

        // 启动用户线程
        new Thread(people).start();

    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你！");
        }
    }
}

class People implements Runnable {

    @Override
    public void run() {
        for (int i = 36500; i >= 0; i--) {
            System.out.println("祝你生活愉快！ --- " + i);
        }
        System.out.println("----------------------");
    }
}
```



## 9. 线程同步

==并发==：多个线程访问同一个对象。

**线程同步就是一个等待机制，多个需要访问此对象的线程进入该对象的等待池中形成队列。**

**==锁机制== synchronized**

存在问题 -- 安全和性能不可兼得：

- 一个线程持有锁会导致其他所有需要此锁的线程挂起。
- 在多线程竞争下，加锁、释放锁会导致比较多的上下文切换和调度延时，引起性能问题。
- 如果一个优先级高的线程等一个优先级低的线程释放锁，会导致优先级导致，引起性能倒置问题。

### 9.1 同步方法

**缺点**：如果将一个大的方法申明为 synchronized 会影响效率。

买票机制：

```java
public class ThreadBuyTicketSynchronized {

    public static void main(String[] args) {
        BuyTicketThread ticket = new BuyTicketThread();

        new Thread(ticket, "老师").start();
        new Thread(ticket, "学生").start();
        new Thread(ticket, "黄牛").start();
    }
}

class BuyTicketThread implements Runnable {

    private int num = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buyTicket();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void buyTicket() throws InterruptedException {
        if (this.num <= 0) {
            flag = false;
            return;
        }

        Thread.sleep(500);

        System.out.println(Thread.currentThread().getName() + " : " + num--);
    }
}
```



### 9.2 同步块

银行取钱：

```java
public class ThreadBankSynchronized {
    public static void main(String[] args) {
        Account account = new Account("基金", 100);

        new Bank(account, 50, "男生").start();
        new Bank(account, 100, "女生").start();
    }
}

class Account {
    private String accountName;
    private int money;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account(String accountName, int money) {
        this.accountName = accountName;
        this.money = money;
    }
}

class Bank extends Thread {

    private Account account; // 取钱账户
    private int drawingMoney; // 取钱数
    private int nowMoney; // 手里的钱数

    public Bank(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        synchronized (account) {
            if (account.getMoney() - drawingMoney < 0) {
                System.out.println(account.getAccountName() + "账户没有那么多钱");
                return;
            }

            nowMoney += drawingMoney;
            account.setMoney(account.getMoney() - drawingMoney);
        }

        System.out.println(this.getName() + "取走：" + drawingMoney);
        System.out.println(this.getName() + "手上有：" + nowMoney);

        System.out.println(account.getAccountName() + "还剩" + account.getMoney());
    }
}
```

list数组：

```java
public class ThreadListSynchronized {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add("添加数据");
                    System.out.println(list.toArray().length);
                }
            }).start();
        }
    }
}
```



## 10. 并发包 concurrent -- JUC

```java
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//  ArrayList<String> list = new ArrayList<>();
for (int i = 0; i < 10000; i++) {
    new Thread(() -> list.add("aaaa")).start();
}

Thread.sleep(3);

System.out.println(list.toArray().length);
```



## 11. 死锁

多个线程各自占有一些共享资源，并且互相等待其他线程占有的资源才能运行，而导致两个或者多个线程都在等待对方释放资源，都停止执行的情形，**某一个同步块同时拥有** ” **两个以上对象的锁** ” 时，就可能会发生 “ 死锁 ” 的问题

产生死锁的**四个必要条件**：

1. 互斥条件：一个资源每次只能被一个进程使用。
2. 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
3. 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。
4. 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

**死锁避免方法**：上面列出了死锁的四个必要条件，我们只要想办法**破其中的任意一个或多个条件**就可以避免死锁发生。

产生死锁：

```java
public class LockTest {
    public static void main(String[] args) {
        new Makeup("灰姑娘", 0).start();
        new Makeup("白雪公主", 1).start();
    }
}

class Lipstick { }

class Mirror { }

class Makeup extends Thread {
    static final Lipstick lipstick = new Lipstick();
    static final Mirror mirror = new Mirror();

    private int choice;
    private String name;

    public Makeup(String name, int choice) {
        this.name = name;
        this.choice = choice;
    }

    @Override
    public void run() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(name + "拿到了lipstick");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (mirror) {
                    System.out.println(name + "拿到了lipstick");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(name + "拿到了mirror");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lipstick) {
                    System.out.println(name + "拿到了lipstick");
                }
            }
        }
    }
}
```

解决死锁：

```java
public class LockTest {
    public static void main(String[] args) {
        new Makeup("灰姑娘", 0).start();
        new Makeup("白雪公主", 1).start();
    }
}

class Lipstick { }

class Mirror { }

class Makeup extends Thread {
    static final Lipstick lipstick = new Lipstick();
    static final Mirror mirror = new Mirror();

    private int choice;
    private String name;

    public Makeup(String name, int choice) {
        this.name = name;
        this.choice = choice;
    }

    @Override
    public void run() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(name + "拿到了lipstick");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (mirror) {
                System.out.println(name + "拿到了lipstick");
            }
        } else {
            synchronized (mirror) {
                System.out.println(name + "拿到了mirror");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (lipstick) {
                System.out.println(name + "拿到了lipstick");
            }
        }
    }
}
```



## 12. Lock锁

- 从JDK5.0开始，Java提供了更强大的线程同步机制一通过**显式定义同步锁对象来实现同步**。同步锁使用**Lock对象**充当
- java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。**锁提供了对共享资源的独占访问**，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应先获得Lock对象
- **ReentrantLock 类实现了Lock**，它拥有与 synchronized 相同的并发性和内存语义，在实现线程安全的控制中，比较常用的是ReentrantLock，可以**显式加锁、释放锁**。

~~~java
class A {
	private final ReentrantLock lock = new ReenTrantLock();
	public.void m() {
		lock.lock();
		try {
			// 保证线程安全的代码；
        }
		finally {
			lock.unlock();
            // 如果同步代码有异常，要将unlock()写入finally语句块
        }
    }
}
~~~



- **Lock是显式锁**（**手动开启和关闭锁，别忘记关闭锁**）synchronized是隐式锁，出了作用域自动释放
- **Lock只有代码块锁，synchronized有代码块锁和方法锁**
- **使用Lock锁，JVM将花费较少的时间来调度线程，性能更好**。并且**具有更好的扩展性** (提供更多的子类)
- 优先使用顺序：
  - **Lock** > 同步代码块（已经进入了方法体，分配了相应资源）>同步方法（在方法体之外)

```java
public class ReentrantLockTest {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
    }
}

class BuyTicket implements Runnable {

    private int num = 10;
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (num > 0) {
                    System.out.println(num--);
                } else {
                    break;
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
```



## 13. 生产者消费者问题 -- 线程通信

**应用场景**：生产者和消费者问题

- 假设仓库中只能存放一件产品，生产者将生产出来的产品放入仓库，消费者将仓库中产品取走消费.
- 如果仓库中没有产品，则生产者将产品放入仓库，否则停止生产并等待，直到仓库中的产品被消费者取走为止
- 如果仓库中放有产品，则消费者可以将产品取走消费，否则停止消费并等待，直到仓库中再次放入产品为止，

这是一个**线程同步问题**，生产者和消费者共享同一个资源，并且生产者和消费者之间相互依赖，互为条件.

- 对于生产者，没有生产产品之前，要通知消费者等待.而生产了产品之后，又需要马上通知消费者消费
- 对于消费者，在消费之后，要通知生产者已经结束消费，需要生产新的产品以供消费.
- 在生产者消费者问题中，仅有synchronized是不够的
  - synchronized 可阻止并发更新同一个共享资源，实现了同步
  - synchronized 不能用来实现不同线程之间的消息传递 (通信)

**Java提供了几个方法解决线程之间的通信问题**

- wait()：表示线程一直等待，直到其他线程通知，与sleep不同，会释放锁
- wait(long timeout)：指定等待的毫秒数
- notify()：唤醒一个处于等待状态的线程
- notifyAII()：唤醒同一个对象上所有调用wait()方法的线程，优先级别高的线程优先调度

==**注意**==：均是Object类的方法，**都只能在同步方法或者同步代码块中使用**，否则会抛出异常**illegalMonitorStateException**

**解决方法1：**

​	并发协作模型“生产者／消费者模式”--->==**管程法**==

- 生产者；负责生产数据的模块(可能是方法，对象，线程，进程)；
- 消费者：负责处理数据的模块(可能是方法，对象，线程，进程);
- 缓冲区：消费者不能直接使用生产者的数据，他们之间有个“缓冲区

​	**生产者将生产好的数据放入缓冲区，消费者从缓冲区拿出数据**

![thread03](E:\notes\img\thread03.png)

**解决方法2：**

​	并发协作模型“生产者／消费者模式”--->==**信号灯法**==





















