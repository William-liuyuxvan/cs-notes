package com.yuxuan;

import java.util.Scanner;

/**
 * @ClassName Ca58
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/23 9:03
 */
public class Ca58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        n = scanner.nextInt();

        int[] array = new int[n];
        int[] prefixSum = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            array[i] = temp;
            sum += temp;
            prefixSum[i] = sum;
        }

        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0) {
                System.out.println(prefixSum[b]);
            } else {
                int ans = prefixSum[b] - prefixSum[a - 1];
                System.out.println(ans);
            }
        }
    }
}
