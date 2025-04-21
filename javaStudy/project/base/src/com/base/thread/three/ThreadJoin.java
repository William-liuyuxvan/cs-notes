package com.base.thread.three;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName ThreadJoin
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 15:46
 */
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
