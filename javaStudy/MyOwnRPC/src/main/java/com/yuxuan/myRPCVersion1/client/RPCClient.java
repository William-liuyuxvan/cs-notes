package com.yuxuan.myRPCVersion1.client;

import com.yuxuan.myRPCVersion1.common.User;
import com.yuxuan.myRPCVersion1.service.UserService;

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

        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        // 调用第一个方法
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);

        // 调用第二个方法
        User user = User.builder().userName("张三").id(1).sex(true).build();
        Integer i = proxy.insertUserId(user);
        System.out.println("向服务端插入数据：" + i);

    }
}
