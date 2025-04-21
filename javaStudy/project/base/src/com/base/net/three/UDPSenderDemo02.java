package com.base.net.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName UDPSenderDemo02
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/11 21:10
 */
public class UDPSenderDemo02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            DatagramPacket packet = new DatagramPacket(line.getBytes(), 0, line.getBytes().length, new InetSocketAddress("localhost", 6667));
            socket.send(packet);

            if (line.equals("bye")) {
                break;
            }
        }

        br.close();
        socket.close();
    }
}
