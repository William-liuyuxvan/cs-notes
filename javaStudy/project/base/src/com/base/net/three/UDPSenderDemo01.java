package com.base.net.three;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPClientDemo01
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 20:50
 */
public class UDPSenderDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. 创建udp通信
        DatagramSocket socket = new DatagramSocket();

        // 2. 创建包
        String msg = "Hello UDP";
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("127.0.0.1"), 9090);

        // 3. 发送包
        socket.send(packet);

        // 4. 关闭流
        socket.close();
    }
}
