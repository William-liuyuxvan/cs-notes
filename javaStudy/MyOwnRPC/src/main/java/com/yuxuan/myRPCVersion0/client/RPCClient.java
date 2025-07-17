package com.yuxuan.myRPCVersion0.client;

import com.yuxuan.myRPCVersion0.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * @ClassName RPCClient
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/22 18:09
 */
public class RPCClient {
    public static void main(String[] args) {
        try {
            // 创建一个Socket连接端口8899
            Socket socket = new Socket("127.0.0.1", 8899);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // 传给服务器一个整数id
            oos.writeInt(new Random().nextInt());
            oos.flush();
            // 服务器查询数据，返回对应的对象
            User user = (User) ois.readObject();
            System.out.println("服务端返回的User: " + user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }
}
