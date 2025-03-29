package com.base.method;

/**
 * @ClassName Demo3
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/24 21:38
 */
public class Demo3 {
    public static void main(String[] args) {
        printMax(1,1,1,1);
    }

    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
        }

        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println(max);
    }
}
