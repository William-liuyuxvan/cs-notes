package com.base.thread.four;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName TestJUC
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 18:02
 */
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> list.add("aaaa")).start();
        }

        Thread.sleep(3);

        System.out.println(list.toArray().length);
    }
}
