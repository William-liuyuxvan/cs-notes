package com.base.reflection.one;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 19:16
 */
public class Test02 {
    public static void main(String[] args) {
        int[] b = new int[10];
        int[] c = new int[20];
        System.out.println(b.getClass().hashCode()); // 356573597
        System.out.println(c.getClass().hashCode()); // 356573597


        int[][] b1 = new int[10][2];
        int[][] c1 = new int[20][2];
        System.out.println(b1.getClass().hashCode()); // 1735600054
        System.out.println(c1.getClass().hashCode()); // 1735600054
    }
}
