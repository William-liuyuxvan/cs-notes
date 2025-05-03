package com.yuxuan.controller;

import com.yuxuan.pojo.Emp;
import com.yuxuan.pojo.LoginInfo;
import com.yuxuan.pojo.Result;
import com.yuxuan.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description 登录控制器
 * @Author eeekuu
 * @Date 2025/4/28 23:29
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录接口被调用，参数：{}", emp);
        LoginInfo info = empService.login(emp);
        if (info != null) {
            return Result.success(info);
        }

        return Result.error("账号或密码错误");
    }

}
