package com.base.net.three;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 21:45
 */
public class Teacher {
    public static void main(String[] args) {
        new Thread(new Sender("localhost", 9099)).start();
        new Thread(new Receiver("学生", 8088)).start();
    }
}
