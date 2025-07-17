package com.yuxuan.test.nio.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @ClassName TestClient
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/29 14:53
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8080));
        sc.write(Charset.defaultCharset().encode("0123456789abcd"));
        System.in.read();
    }
}
