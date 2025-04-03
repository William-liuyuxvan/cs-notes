package com.base.io.recursion;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @ClassName demo3
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/3 17:20
 */
public class Demo3 {
    public static void main(String[] args) throws Exception {
        String str = "a我m";
        // 编码
        byte[] bytes1 = str.getBytes(); // utf-8   5字节
        System.out.println(Arrays.toString(bytes1));
        byte[] bytes2 = str.getBytes("GBK"); // gbk   4字节
        System.out.println(Arrays.toString(bytes2));

        // 解码
        String s1 = new String(bytes1);
        System.out.println(s1);

        // 编码与解码不一致
        String s2 = new String(bytes2);
        System.out.println(s2);

        String s3 = new String(bytes2, "GBK");
        System.out.println(s3);
    }
}
