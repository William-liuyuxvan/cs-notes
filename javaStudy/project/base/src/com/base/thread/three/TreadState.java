package com.base.thread.three;

/**
 * @ClassName TreadState
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 15:56
 */
public class TreadState {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("-------------");
            }
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(200);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
