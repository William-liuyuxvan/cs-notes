package com.base.thread.three;

/**
 * @ClassName ThreadPriority
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 16:24
 */
public class ThreadPriority {
    public static void main(String[] args) {

        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());

        MyPriorityThread myThread = new MyPriorityThread();

        Thread t1 = new Thread(myThread, "1");
        Thread t2 = new Thread(myThread, "2");
        Thread t3 = new Thread(myThread, "3");
        Thread t4 = new Thread(myThread, "4");
        Thread t5 = new Thread(myThread, "5");

        t1.setPriority(1);
        t1.start();

        t2.setPriority(5);
        t2.start();

        t3.setPriority(7);
        t3.start();

        t4.setPriority(10);
        t4.start();

        t5.setPriority(2);
        t5.start();



    }
}

class MyPriorityThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
    }
}
