package com.yuxuan.myRPCVersion0.server;

import com.yuxuan.myRPCVersion0.common.User;
import com.yuxuan.myRPCVersion0.service.UserService;

import java.util.Random;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/22 18:07
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了" + id + "的用户");
        // 模拟从数据库中查询用户信息
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();
        return user;
    }
}
