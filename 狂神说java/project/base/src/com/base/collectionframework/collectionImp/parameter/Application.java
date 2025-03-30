package com.base.collectionframework.collectionImp.parameter;

import java.util.Arrays;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 20:54
 */
public class Application {
    public static void main(String[] args) {
        test(); // 0 []
        test(10); // 1 [10]
        test(10, 20, 30, 40); // 4 [10, 20, 30, 40]
        test(new int[]{10, 20, 30, 40}); // 4 [10, 20, 30, 40]
    }

    public static void test(int... nums) {
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println("---------------------------");
    }
}
