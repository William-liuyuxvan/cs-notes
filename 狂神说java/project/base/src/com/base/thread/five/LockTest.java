package com.base.thread.five;

/**
 * @ClassName LockTest
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 18:18
 */
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
