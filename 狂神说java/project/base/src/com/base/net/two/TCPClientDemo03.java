package com.base.net.two;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName TCPClientDemo03
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 20:18
 */
public class TCPClientDemo03 {
    public static void main(String[] args) throws Exception {
        // 1. 连接socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

        // 2. 创建输出流
        OutputStream os = socket.getOutputStream();

        // 3. 创建输入流
        FileInputStream fis = new FileInputStream("C:/Users/eeekuu/Pictures/照片/11111111 (1).jpg");

        byte[] buffer = new byte[1024];
        int len;

        // 4. 读入文件，输出到管道
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        // 5. 通知已经传输完毕
        socket.shutdownOutput();

        // 6. 接收信息
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }
        System.out.println(baos);

        // 7. 关闭流
        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
