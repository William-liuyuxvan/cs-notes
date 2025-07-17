package com.yuxuan.myRPCVersion3.client;

import com.yuxuan.myRPCVersion3.common.RPCRequest;
import com.yuxuan.myRPCVersion3.common.RPCResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ClassName IOClient
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/23 11:52
 */
public class IOClient {
    // 这里负责底层与服务端的通信，发送的Request，接受的是Response对象
    // 客户端发起一次请求调用，Socket建立连接，发起请求Request，得到响应Response
    public static RPCResponse sentRequest(String host, int port, RPCRequest request) {
        try {
            Socket socket = new Socket(host, port);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            // 发送
            System.out.println(request);
            oos.writeObject(request);
            oos.flush();

            // 接收
            RPCResponse response = (RPCResponse) ois.readObject();
            return response;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            return null;
        }
    }
}
