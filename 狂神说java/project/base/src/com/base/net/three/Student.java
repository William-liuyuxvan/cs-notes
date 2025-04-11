package com.base.net.three;

/**
 * @ClassName Student
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 21:43
 */
public class Student {
    public static void main(String[] args) {
        new Thread(new Sender("localhost", 8088)).start();
        new Thread(new Receiver("老师", 9099)).start();
    }
}
