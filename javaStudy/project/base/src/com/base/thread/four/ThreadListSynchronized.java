package com.base.thread.four;

import java.util.ArrayList;

/**
 * @ClassName ThreadListSynchronized
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 17:53
 */
public class ThreadListSynchronized {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add("添加数据");
                    System.out.println(list.toArray().length);
                }
            }).start();
        }
    }
}
