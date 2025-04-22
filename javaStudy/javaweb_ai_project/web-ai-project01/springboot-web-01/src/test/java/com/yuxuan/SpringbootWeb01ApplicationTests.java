package com.yuxuan;

import com.yuxuan.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringbootWeb01ApplicationTests {

    @Test
    void testUserAllArgsConstructor() {
        User user = new User(); // 使用带参数的构造器
        System.out.println(
                "id: " + user.getId() + "\n" +
                "username: " + user.getUsername() + "\n" +
                "password: " + user.getPassword() + "\n" +
                "name: " + user.getName() + "\n" +
                "age: " + user.getAge() + "\n" +
                "updateTime: " + user.getUpdateTime()
        );
    }

}
