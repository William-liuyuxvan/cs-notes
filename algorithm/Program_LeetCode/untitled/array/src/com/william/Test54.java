package com.william;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test54
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/22 22:07
 */
public class Test54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        int cnt = 0;
        int val = matrix.length;
        int col = matrix[0].length;
        int total = val * col;

        boolean[][] flag = new boolean[val][col];

        res.add(matrix[i][j]);
        flag[i][j] = true;
        cnt++;

        while (cnt < total) {
            while (cnt < total && j + 1 < col && !flag[i][j + 1]) { // 右
                res.add(matrix[i][j + 1]);
                flag[i][++j] = true;
                cnt++;
            }
            while (cnt < total && i + 1 < val && !flag[i + 1][j]) { // 下
                res.add(matrix[i + 1][j]);
                flag[++i][j] = true;
                cnt++;
            }
            while (cnt < total && j - 1 >= 0 && !flag[i][j - 1]) { // 左
                res.add(matrix[i][j - 1]);
                flag[i][--j] = true;
                cnt++;
            }
            while (cnt < total && i - 1 >= 0 && !flag[i - 1][j]) { // 上
                res.add(matrix[i - 1][j]);
                flag[--i][j] = true;
                cnt++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new Test54().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
