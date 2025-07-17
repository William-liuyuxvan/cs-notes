package com.yuxuan.test.nio;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName NioSelectorServer
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/26 23:51
 */
public class NioSelectorServer {
    public static void main(String[] args) {
        // 开启nio  注册端口9000
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9000));
            serverSocketChannel.configureBlocking(false);
            // 开启多路复用   注册监听
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务启动成功");

            while (true) {
                // 阻塞等待需要处理的事件发生
                selector.select();

                // 获取selector中注册的全部事件的 SelectorKey 实例
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = server.accept();
                        socketChannel.configureBlocking(false); // 非阻塞
                        socketChannel.register(selector, SelectionKey.OP_READ); // 监听读事件
                        System.out.println("客户端连接成功");
                    } else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(6);
                        int length = socketChannel.read(byteBuffer);
                        if (length > 0) {
                            System.out.println("客户端消息： " + new String(byteBuffer.array()));
                        } else if (length == -1) {
                            System.out.println("客户端断开连接");
                            socketChannel.close();
                        }
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("NIO打开失败");
        }

    }
}
