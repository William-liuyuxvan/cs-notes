package com.base.net.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName Sender
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 21:31
 */
public class Sender implements Runnable {

    private final DatagramSocket socket;
    private final BufferedReader br;

    private String toIP;
    private int toPort;

    public Sender(String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket();
            br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = br.readLine();
                byte[] bytes = data.getBytes("UTF-8");
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(this.toIP, this.toPort));
                socket.send(packet);

                if (data.equals("bye")) break;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
