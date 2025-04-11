package com.base.net.three;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName UDPServerDemo02
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 20:50
 */
public class UDPReceiverDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. 创建udp通信
        DatagramSocket socket = new DatagramSocket(9090);

        // 2. 创建接收包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 3. 接收包
        socket.receive(packet);

        // 4. 打印接收包
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        // 5. 关闭流
        socket.close();
    }
}
