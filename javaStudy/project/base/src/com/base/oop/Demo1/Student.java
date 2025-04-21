package com.base.oop.Demo1;

/**
 * @ClassName Person
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/25 19:44
 */
public class Student extends Person {
    private String name;
    private int age;

    public void print() {
        System.out.println("Student");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
