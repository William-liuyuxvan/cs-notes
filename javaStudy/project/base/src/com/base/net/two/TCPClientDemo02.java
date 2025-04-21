package com.base.net.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName TCPClientDemo01
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/10 20:23
 */
public class TCPClientDemo02 {
    public static void main(String[] args) throws Exception {
        // 1. 知道服务器地址和端口
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8088;
        // 2. 创建socket 与服务端建立连接
        Socket socket = new Socket(address, port);

        // 3. 获取发送窗口
        OutputStream outputStream = socket.getOutputStream();

        // 4. 创建接收窗口
        InputStream inputStream = socket.getInputStream();

        System.out.println("与服务端连接成功！");

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
            } catch (Exception e) {
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

                    outputStream.flush(); // 强制刷新缓冲区，防止数据丢失，立即发送数据
                    if (line.equals("exit")) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        send.start();

        send.join();
        receive.join();

        socket.close();
    }
}
