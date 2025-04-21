package com.base.oop.Demo1;

/**
 * @ClassName main
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/25 19:44
 */
public class Application {
    public static void main(String[] args) {
        Student student1 = new Student();
        Person student2 = new Student();

        student1.print();
        student2.print();

        String name = student1.getName();
    }
}
