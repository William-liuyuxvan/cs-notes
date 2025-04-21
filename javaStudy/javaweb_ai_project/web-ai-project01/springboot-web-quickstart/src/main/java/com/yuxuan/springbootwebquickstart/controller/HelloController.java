package com.yuxuan.springbootwebquickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/21 21:09
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String get(String name) {
        System.out.println(name);
        return name;
    }
}
