package com.base.method;

/**
 * @ClassName Dome1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/24 21:09
 */
public class Demo1 {
    public static void main(String[] args) {
        double max = max(10, 10);
        System.out.println(max);


    }

    private static int max(int i, int j) {
        return i > j ? i : j;
    }
    private static double max(double i, double j) {
        return i > j ? i : j;
    }

}
