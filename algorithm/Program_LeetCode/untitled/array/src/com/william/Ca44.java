package com.william;

import java.util.Scanner;

/**
 * @ClassName Ca44
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/23 9:40
 */
public class Ca44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = scanner.nextInt();
                matrix[i][j] = num;
                col[j] += num;
                row[i] += num;
            }
        }

        int sumRow = 0;
        int sumCol = 0;
        for (int i = 0; i < n; i++) {
            sumRow += row[i];
            row[i] = sumRow;
            // System.out.println(row[i]);
        }

        for (int j = 0; j < m; j++) {
            sumCol += col[j];
            col[j] = sumCol;
            // System.out.println(col[j]);
        }

        int value = Integer.MAX_VALUE; // 差值
        // 先row分
        for (int k = 1; k < n; k++) {
            int temp = row[n - 1] - row[k - 1] * 2;
            int before = (int) value;
            value = Math.min(value, Math.abs(temp));
            // System.out.println("temp: " + temp + " before: " + before + " value: " + value);
        }

        // 后col分
        for (int k = 1; k < m; k++) {
            int temp =col[m - 1] - col[k - 1] * 2;
            int before = (int) value;
            value = Math.min(value, Math.abs(temp));
            // System.out.println("temp: " + temp + " before: " + before + " value: " + value);
        }

        System.out.println(value);
    }
}
