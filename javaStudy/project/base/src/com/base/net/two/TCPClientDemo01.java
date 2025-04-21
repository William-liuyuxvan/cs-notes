package com.base.net.two;

import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @ClassName TCPClientDemo01
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/10 20:23
 */
public class TCPClientDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. 知道服务器地址和端口
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8088;
        try (
                // 2. 创建socket 与服务端建立连接
                Socket socket = new Socket(address, port);

                // 3. 获取发送消息窗口
                OutputStream outputStream = socket.getOutputStream();

                Scanner scanner = new Scanner(System.in);
                    ) {

            while (true) {
                // 4. 发送消息
                String line = scanner.nextLine();
                outputStream.write(line.getBytes());

                if (line.equals("exit")) {
                    break;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
