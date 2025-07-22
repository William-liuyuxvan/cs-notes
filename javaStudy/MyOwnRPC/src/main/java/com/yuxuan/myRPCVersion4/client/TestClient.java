package com.yuxuan.myRPCVersion4.client;

import com.yuxuan.myRPCVersion4.common.Blog;
import com.yuxuan.myRPCVersion4.common.User;
import com.yuxuan.myRPCVersion4.service.BlogService;
import com.yuxuan.myRPCVersion4.service.UserService;

/**
 * @ClassName TestClient
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/7/22 16:59
 */
public class TestClient {
    public static void main(String[] args) {
        RPCClient rpcClient = new NettyRPCClient("127.0.0.1", 8899);
        RPCClientProxy rpcClientProxy = new RPCClientProxy(rpcClient);

        UserService userService = rpcClientProxy.getProxy(UserService.class);
        User userByUserId = userService.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);

        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = userService.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);

        BlogService blogService = rpcClientProxy.getProxy(BlogService.class);

        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);
    }
}
