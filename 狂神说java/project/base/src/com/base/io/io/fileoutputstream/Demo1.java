package com.base.io.io.fileoutputstream;

import java.io.*;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/3 20:32
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("base/src/com/base/io/testOut.txt", true);

        os.write(97);
        os.write('b');
        os.write("我爱你中国".getBytes());
        os.write("\r\n".getBytes());

        os.close();
    }
}
