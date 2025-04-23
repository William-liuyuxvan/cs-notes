package com.william;

/**
 * @ClassName Test146
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/22 22:41
 */
public class Test146 {
    public int[] spiralArray(int[][] array) {
        if (array.length == 0) return new int[0];

        int row = array.length, col = array[0].length;
        int cnt = 0;
        boolean[][] flag = new boolean[row][col];
        int total = row * col;
        int i = 0, j = 0;
        int[] ans = new int[total];

        ans[cnt++] = array[i][j];
        flag[i][j] = true;

        while (cnt < total) {
            while (cnt < total && j + 1 < col && !flag[i][j + 1]) { // 右
                ans[cnt++] = array[i][++j];
                flag[i][j] = true;
            }
            while (cnt < total && i + 1 < row && !flag[i + 1][j]) { // 下
                ans[cnt++] = array[++i][j];
                flag[i][j] = true;
            }
            while (cnt < total && j - 1 >= 0 && !flag[i][j - 1]) { // 左
                ans[cnt++] = array[i][--j];
                flag[i][j] = true;
            }
            while (cnt < total && i - 1 >= 0 && !flag[i - 1][j]) { // 上
                ans[cnt++] = array[--i][j];
                flag[i][j] = true;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new Test146().spiralArray(new int[][]{
                {2,3,4},
                {5,6,7},
                {8,9,10},
                {11,12,13},
                {14,15,16}
        });

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
