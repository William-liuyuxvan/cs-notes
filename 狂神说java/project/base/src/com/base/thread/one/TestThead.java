package com.base.thread.one;

/**
 * @ClassName TestThead
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 9:54
 */
public class TestThead extends Thread {
    @Override
    public void run() {
        // run 方法体
        for (int i = 0; i < 20; i++) {
            System.out.println("run : " + i);
        }
    }

    public static void main(String[] args) {
        // 启动线程
        new TestThead().start();

        // 注意：不能使用 .run  这样是调用方法，使用的主线程中的资源
//        new TestThead().run();

        // 主方法
        for (int i = 0; i < 20; i++) {
            System.out.println("main : " + i);
        }
    }
}
