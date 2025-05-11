package com.yuxuan;

import java.util.Scanner;

/**
 * @ClassName Ca54
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/29 16:35
 */
public class Ca54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        StringBuffer sb = new StringBuffer();
        String ap = "number";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                sb.append(ap);
            }
        }

        System.out.println(sb);
    }
}
