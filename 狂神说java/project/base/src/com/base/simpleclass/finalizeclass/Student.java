package com.base.simpleclass.finalizeclass;

/**
 * @ClassName Student
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/27 16:32
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.name + " 被销毁！");
        super.finalize();
    }
}
