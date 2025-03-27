package com.yuxuan.simpleclass.interclass;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/27 9:22
 */
public class Outer {
    private String name = "zhangssan";
    private int age = 18;

    class Inner {
        private String address = "beijing";
        private int phone = 111;
        private String name = "xiaoming";

        public void show() {
            System.out.println("Outer::name: " + name + "\nOuter::age: " + age + "\nInner::address: " + address + "\nInner::phone: " + phone);
        }
    }
}
