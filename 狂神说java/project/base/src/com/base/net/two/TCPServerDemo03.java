package com.base.net.two;

import javafx.scene.chart.Axis;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCP
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 20:19
 */
public class TCPServerDemo03 {
    public static void main(String[] args) throws Exception {
        // 1. 创建socket
        ServerSocket serverSocket = new ServerSocket(9000);

        // 2. 等待连接
        Socket accept = serverSocket.accept();

        // 3. 创建输入流
        InputStream is = accept.getInputStream();

        byte[] buffer = new byte[1024];
        int len;

        // 4. 创建输出流
        FileOutputStream fos = new FileOutputStream(new File("base/src/com/base/net/two/photo.jpg"));

        // 5. 输出
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 6. 通知
        // 通知客户端已经接收完毕
        OutputStream os = accept.getOutputStream();
        os.write("已经接收完毕".getBytes());

        // 7. 关闭流
        os.close();
        fos.close();
        is.close();
        accept.close();
        serverSocket.close();
    }
}
