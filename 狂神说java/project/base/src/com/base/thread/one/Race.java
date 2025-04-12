package com.base.thread.one;

/**
 * @ClassName Race
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 10:56
 */

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
