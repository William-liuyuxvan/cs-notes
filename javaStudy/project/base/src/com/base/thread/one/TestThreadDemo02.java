package com.base.thread.one;

/**
 * @ClassName TestThreadDemo02
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 10:46
 */

// 线程并发问题不安全，访问统一数据时不安全。
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
