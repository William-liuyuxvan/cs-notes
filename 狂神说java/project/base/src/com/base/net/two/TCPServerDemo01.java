package com.base.net.two;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServerDemo01
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/10 20:24
 */
public class TCPServerDemo01 {
    public static void main(String[] args) {
        try (
                // 1. 创建服务端端口 8088
                ServerSocket serverSocket = new ServerSocket(8088);

                // 2. 等待连接
                Socket accept = serverSocket.accept();

                // 3. 创建接收窗口
                InputStream inputStream = accept.getInputStream();

                // 4. 创建管道流
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ) {

            // 5. 建立缓冲区
            byte[] buffer = new byte[1024];
            int len;

            flag1 : while (true) {
                // 6. 接收信息
                while ((len = inputStream.read(buffer)) != -1) {
//                    baos.write(buffer, 0, len);

                    // 7. 打印输出
                    System.out.println(new String(buffer, 0, len));

                    if ((new String(buffer, 0, len)).equals("exit")) {
                        break flag1;
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
