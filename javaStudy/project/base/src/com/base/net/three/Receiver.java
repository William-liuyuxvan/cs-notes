package com.base.net.three;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName Receiver
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 21:37
 */
public class Receiver implements Runnable {

    private final DatagramSocket socket;

    private String fromName;
    private int fromPort;

    public Receiver(String fromName, int fromPort) {
        this.fromName = fromName;
        this.fromPort = fromPort;

        try {
            socket = new DatagramSocket(this.fromPort);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);

//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                baos.write(packet.getData(), 0, packet.getLength());

                String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");

                System.out.println(fromName + ": " + data);

                if (data.equals("bye")) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
