package com.base.io.recursion;

/**
 * @ClassName demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/3 16:23
 */
public class Demo1 {
    public static void main(String[] args) {
        int res = add1ToN(6);
        System.out.println(res);
    }

    private static int add1ToN(int i) {
        if (i < 0) return -1;

        if (i == 0) return 0;
        else return add1ToN(i - 1) + i;
    }
}
