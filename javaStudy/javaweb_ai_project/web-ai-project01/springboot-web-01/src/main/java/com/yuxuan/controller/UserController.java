package com.yuxuan.controller;

import com.yuxuan.pojo.User;
import com.yuxuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/22 19:07
 */
@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> listAll() {
        List<User> list = userService.list();
        return list;
    }

}
