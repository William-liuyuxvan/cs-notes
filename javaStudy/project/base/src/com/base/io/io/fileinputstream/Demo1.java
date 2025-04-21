package com.base.io.io.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/3 19:56
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("base\\src\\com\\base\\io\\test.txt");

        long length = new File("base\\src\\com\\base\\io\\test.txt").length();
        byte[] buffer = new byte[(int)length];
        int size = is.read(buffer);
        System.out.println(new String(buffer, 0, size));

        System.out.println("lenth: " + length + "  size:" + size);
        is.close();
    }
}
