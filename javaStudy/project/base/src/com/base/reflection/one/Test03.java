package com.base.reflection.one;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 19:33
 */

/*
    1. 加载：加载到内存，产生类对应的Class对象
    2. 链接：将static分配内存，默认初始化
    3. 初始化：合并
            <clinit>() {
                System.out.println("static A");
                m = 4;
                m = 2;
            }
            m = 2;
 */
public class Test03 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);
    }
}

class A {

    static {
        System.out.println("static A");
        m = 4;
    }

    static int m = 2;

    public A() {
        System.out.println("初始化A");
    }
}
