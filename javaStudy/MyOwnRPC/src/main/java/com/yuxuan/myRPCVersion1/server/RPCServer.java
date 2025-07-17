package com.yuxuan.myRPCVersion1.server;

import com.yuxuan.myRPCVersion1.common.RPCRequest;
import com.yuxuan.myRPCVersion1.common.RPCResponse;
import com.yuxuan.myRPCVersion1.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName RPCServer
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/22 18:07
 */
public class RPCServer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务器启动成功！");
            // 使用 BIO的方式监听Socket
            while (true) {
                Socket accept = serverSocket.accept();
                // 开启线程去处理请求
                new Thread(() -> {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
                        // 获取客户端的Request
                        RPCRequest request = (RPCRequest) ois.readObject();
                        // 调用对应方法
                        Method method = userService.getClass().getMethod(request.getMethodName(), request.getParamsTypes());
                        Object invoke = method.invoke(userService, request.getParams());
                        // 返回Response
                        oos.writeObject(RPCResponse.success(invoke));
                        oos.flush();
                    } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        e.printStackTrace();
                        System.out.println("从IO中读取数据错误！");
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败！");
        }
    }
}
