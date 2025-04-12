package com.base.thread.three;

import java.util.Arrays;

/**
 * @ClassName TestLambda
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 12:21
 */
public class TestLambda {
    public static void main(String[] args) {
        Test t = System.out::println;
        t.lambda("haha");
    }
}

interface Test {
    void lambda(String msg);
}
