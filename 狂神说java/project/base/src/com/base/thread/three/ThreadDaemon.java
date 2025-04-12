package com.base.thread.three;

/**
 * @ClassName ThreadDaemon
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 16:48
 */
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
