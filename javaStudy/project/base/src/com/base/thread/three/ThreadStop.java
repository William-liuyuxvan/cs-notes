package com.base.thread.three;

/**
 * @ClassName ThreadStop
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 15:11
 */
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
