package com.yuxuan;

/**
 * @ClassName ThreadLocalTest
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 15:30
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("main:string");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : " + local.get());

                local.set("thread1:string");
                System.out.println(Thread.currentThread().getName() + " : " + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + " : " + local.get());

    }
}
