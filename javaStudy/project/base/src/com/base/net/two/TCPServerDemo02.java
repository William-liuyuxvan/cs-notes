package com.base.net.two;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName TCPServerDemo01
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/10 20:24
 */
public class TCPServerDemo02 {
    public static void main(String[] args) throws Exception {
        // 1. 创建服务端端口 8088
        ServerSocket serverSocket = new ServerSocket(8088);

        // 2. 等待连接
        Socket accept = serverSocket.accept();

        // 3. 创建接收窗口
        InputStream inputStream = accept.getInputStream();

        // 4. 获取发送窗口
        OutputStream outputStream = accept.getOutputStream();

        System.out.println("与客户端连接成功！");

        Thread receive = new Thread(() -> {
            try {
                // 5. 建立缓冲区
                byte[] buffer = new byte[1024];
                int len;

                // 6. 接收信息
                while ((len = inputStream.read(buffer)) != -1) {
                    // 7. 打印输出
                    System.out.println(new String(buffer, 0, len));

                    if ((new String(buffer, 0, len)).equals("exit")) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        receive.start();

        // 发送线程
        Thread send = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in);) {
                while (true) {
                    // 4. 发送消息
                    String line = scanner.nextLine();
                    outputStream.write(line.getBytes());

                    outputStream.flush();
                    if (line.equals("exit")) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        send.start();

        send.join();
        receive.join();
    }
}
