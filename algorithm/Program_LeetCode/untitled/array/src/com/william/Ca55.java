package com.william;

import java.util.Scanner;

/**
 * @ClassName Ca55
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 9:33
 */
public class Ca55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        String str = scanner.next();

        String sb = str.substring(str.length() - len) +
                str.substring(0, str.length() - len);

        System.out.println(sb);
    }

}
