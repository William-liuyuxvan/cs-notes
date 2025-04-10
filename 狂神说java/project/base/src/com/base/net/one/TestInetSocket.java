package com.base.net.one;

import java.net.InetSocketAddress;

/**
 * @ClassName TestInetSocket
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/10 12:36
 */
public class TestInetSocket {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);

        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getPort());
    }
}
