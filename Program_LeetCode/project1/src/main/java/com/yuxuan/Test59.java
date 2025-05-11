package com.yuxuan;

/**
 * @ClassName Test
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/22 20:41
 */
public class Test59 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];

        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        int i = 0, j = 0; // 记录 matrix 的横纵坐标 i 纵坐标  j 横坐标
        int total = n * n;
        int cnt = 2; // 计数

        while (cnt <= total) {
            while(cnt <= total && j + 1 < n && matrix[i][j + 1] == 0) { // 右
                matrix[i][++j] = cnt;
                ++cnt;
            }
            while(cnt <= total && (i + 1) < n && matrix[i + 1][j] == 0) { // 下
                matrix[++i][j] = cnt;
                ++cnt;
            }
            while(cnt <= total && (j - 1) >= 0 && matrix[i][j - 1] == 0) { // 左
                matrix[i][--j] = cnt;
                ++cnt;
            }
            while(cnt <= total && (i - 1) >= 0 && matrix[i - 1][j] == 0) { // 上
                matrix[--i][j] = cnt;
                ++cnt;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = new Test59().generateMatrix(3);

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
