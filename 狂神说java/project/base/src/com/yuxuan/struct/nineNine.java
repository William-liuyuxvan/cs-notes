package com.yuxuan.struct;

/**
 * @ClassName nineNine
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/24 20:33
 */
public class nineNine {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                int tmp = i * j;
                System.out.printf(j + " * " + i + " = " + tmp + "\t");
            }
            System.out.println();
        }
    }
}
