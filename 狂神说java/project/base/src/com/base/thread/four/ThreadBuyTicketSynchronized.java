package com.base.thread.four;

import sun.misc.OSEnvironment;

import java.nio.channels.Pipe;

/**
 * @ClassName ThreadBuyTicketSynchronized
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 17:32
 */
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
