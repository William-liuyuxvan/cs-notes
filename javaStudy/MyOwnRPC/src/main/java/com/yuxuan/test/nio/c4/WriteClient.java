package com.yuxuan.test.nio.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName WriteClient
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/29 11:12
 */
public class WriteClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8080));

        int read = 0;
        while (true) {
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
            read += sc.read(buffer);
            System.out.println(read);
            buffer.clear();
        }
    }
}
