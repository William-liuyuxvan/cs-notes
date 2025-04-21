package com.base.oop.Demo2;

/**
 * @ClassName main
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/25 19:44
 */
public class Application {
    public static void main(String[] args) {
        AbstractDemo abstractDemo = new AbstractDemo() {
            @Override
            public void print() {
                System.out.println("Hello World");
            }
        };

        abstractDemo.print();
    }
}
