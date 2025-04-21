package com.base.reflection.one;

import java.util.Arrays;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 16:22
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.base.reflection.one.User");

        System.out.println(c1.getName());
        Arrays.stream(c1.getFields()).forEach(System.out::println);
//        Arrays.stream(c1.getMethods()).forEach(System.out::println);
    }
}

class User {
    private String name;
    private String name1;
    private String name2;
    private String name3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
