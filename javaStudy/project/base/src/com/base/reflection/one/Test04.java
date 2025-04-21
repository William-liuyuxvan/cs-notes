package com.base.reflection.one;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 19:45
 */
public class Test04 {

    public static void main(String[] args) {
        System.out.println(Son.m); // Father static ; 2
        System.out.println(Son.a); // Father static ;  2 ; Son static ; 3
        System.out.println(Son.B); // 1

        Son[] sons = new Son[2]; // 空
    }
}

class Father {
    static {
        System.out.println("Father static");
    }

    static int m = 2;

    static final int B = 1;
}

class Son extends Father {
    static {
        System.out.println("Son static");
    }

    static int a = 3;
}
