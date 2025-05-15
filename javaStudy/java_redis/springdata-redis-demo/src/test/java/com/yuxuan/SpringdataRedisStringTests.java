package com.yuxuan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuxuan.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringdataRedisStringTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("name", "虎哥");
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    // JSON工具
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testSaveUser() throws JsonProcessingException {
        // 1. 准备对象
        User user = new User("虎哥", 21);

        // 2. 手动序列化
        String json = mapper.writeValueAsString(user);

        // 3. 写入数据
        stringRedisTemplate.opsForValue().set("user:200", json);

        // 4. 读取数据
        String s = stringRedisTemplate.opsForValue().get("user:200");

        // 5. 手动反序列化
        User user1 = mapper.readValue(s, User.class);

        // 6. 输出
        System.out.println("user1 = " + user1);
    }
}
