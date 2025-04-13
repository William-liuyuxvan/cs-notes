package com.base.thread.six;

/**
 * @ClassName TestPC02
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 13:29
 */
public class TestPC02 {

    public static void main(String[] args) {
        TV tv = new TV();

        Thread thread = new Thread(new Player(tv), "表演者1");
        thread.setDaemon(true);
        thread.start();
        new Thread(new Watcher(tv), "观众1").start();
        new Thread(new Watcher(tv), "观众2").start();
    }
}

class Player implements Runnable {

    private TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0;; i++) {
            if (i % 2 == 0) tv.play("爱奇艺");
            else tv.play("腾讯");

            System.out.println(Thread.currentThread().getName() + "表演了" + tv.getShow());
        }
    }
}

class Watcher implements Runnable {

    private TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "观看了" + tv.watch());
        }
    }
}

class TV {

    private String show;

    private static boolean flag; // T 表演  F 观看

    public TV() {
        init();
    }

    private void init() {
        flag = true; // 先表演
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public synchronized void play(String show) {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.setShow(show);
        flag = false;
        this.notifyAll();
    }

    public synchronized String watch() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String s = this.getShow();
        flag = true;
        this.notifyAll();
        return s;
    }
}
