package com.base.net.three;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName UDPSenderDemo02
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 21:10
 */
public class UDPReveicerDemo02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6667);

        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, container.length);

            socket.receive(packet);

            String data = new String(packet.getData(), 0, packet.getLength());
            System.out.println(data);
            System.out.println(new String(container));

            if (data.equals("bye")) {
                break;
            }
        }

        socket.close();
    }
}
