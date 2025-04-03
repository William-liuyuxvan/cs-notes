package com.base.io.io.copy;

import java.io.*;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/3 20:36
 */
public class Demo {
    public static void main(String[] args) {
//        InputStream is = null;
//        OutputStream os = null;
//        try {
//            is = new FileInputStream("base\\src\\com\\base\\io\\test.txt");
//            os = new FileOutputStream("base/src/com/base/io/testOut.txt");
//
//            byte[] bytes = new byte[1024];
//            int size = -1;
//            while ((size = is.read(bytes)) != -1) {
//                os.write(bytes, 0, size);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // 一般的关流顺序为后创建先关，先创建后关
//            try {
//                if (os != null) os.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                if (is != null) is.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        System.out.println("拷贝成功");

        try (InputStream is = new FileInputStream("base\\src\\com\\base\\io\\test.txt");
                OutputStream os = new FileOutputStream("base/src/com/base/io/testOut.txt");
             MyConnection conn = new MyConnection()) {
            byte[] bytes = new byte[1024];
            int size = -1;
            while ((size = is.read(bytes)) != -1) {
                os.write(bytes, 0, size);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("拷贝成功");
    }
}
