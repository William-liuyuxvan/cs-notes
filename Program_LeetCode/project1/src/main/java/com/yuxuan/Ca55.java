package com.yuxuan;

import java.util.Scanner;

/**
 * @ClassName Ca55
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 9:33
 */
public class Ca55 {
    // 自实现：利用字符串自己的函数
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int len = scanner.nextInt();
//        String str = scanner.next();
//
//        String sb = str.substring(str.length() - len) +
//                str.substring(0, str.length() - len);
//
//        System.out.println(sb);
//    }

    // 推荐：通过char数组进行反转数组
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();

        int length = str.length();

        char[] charArray = str.toCharArray();

        // 先反转整个字符串
        reverse(charArray, 0, length - 1);
        // 再反转前面字符串
        reverse(charArray, 0, n - 1);
        // 最后反转后面字符串
        reverse(charArray, n, length - 1);

        System.out.println(charArray);
    }

    // 反转函数
    private static void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            charArray[start] ^= charArray[end];
            charArray[end] ^= charArray[start];
            charArray[start] ^= charArray[end];

            start++;
            end--;
        }
    }

}
