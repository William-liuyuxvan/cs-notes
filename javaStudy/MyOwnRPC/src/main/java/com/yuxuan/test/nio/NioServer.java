package com.yuxuan.test.nio;

import io.netty.util.CharsetUtil;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName NioServer
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/26 15:22
 */
public class NioServer {
    private static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            socketChannel.socket().bind(new InetSocketAddress(9000));
            socketChannel.configureBlocking(false);

            while (true) {
                 SocketChannel accept = socketChannel.accept();
                if (accept != null) {
                    System.out.println("连接成功");
                    accept.configureBlocking(false);
                    channelList.add(accept);
                } else {
                    System.out.println("未连接");
                }
                Iterator<SocketChannel> iterator = channelList.iterator();
                while (iterator.hasNext()) {
                    SocketChannel channel = iterator.next();
                    // 缓存
                    ByteBuffer byteBuffer = ByteBuffer.allocate(6);
                    int length = channel.read(byteBuffer);
                    if (length > 0) {
                        System.out.println("信息：" + new String(byteBuffer.array()));
                    } else if (length < 0) {
                        System.out.println("退出连接");
                        iterator.remove();
                    }
                }

            }

        } catch (IOException e) {
            System.err.println("连接失败");;
        }
    }
}
