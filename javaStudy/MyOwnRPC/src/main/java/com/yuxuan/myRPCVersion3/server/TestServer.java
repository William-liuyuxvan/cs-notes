package com.yuxuan.myRPCVersion3.server;

import com.yuxuan.myRPCVersion3.service.BlogServiceImpl;
import com.yuxuan.myRPCVersion3.service.BlogService;
import com.yuxuan.myRPCVersion3.service.UserService;
import com.yuxuan.myRPCVersion3.service.UserServiceImpl;

/**
 * @ClassName TestSrver
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/23 16:58
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogServer = new BlogServiceImpl();

//        Map<String, Object> serviceProvide = new HashMap<>();
        // 暴露两个服务接口， 即在RPCServer中加一个HashMap
//        serviceProvide.put("com.yuxuan.myRPCVersion1.service.UserService", userService);
//        serviceProvide.put("com.yuxuan.myRPCVersion1.service.BlogService", blogServer);

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogServer);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
