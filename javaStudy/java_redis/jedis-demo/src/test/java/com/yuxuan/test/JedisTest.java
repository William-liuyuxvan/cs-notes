package com.yuxuan.test;

import com.yuxuan.utils.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @ClassName JedisTest
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/14 19:44
 */

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    public void setUp() {
//        jedis = new Jedis("192.168.100.128", 6379);
        jedis = JedisConnectionFactory.getJedis();
//        jedis.auth("123321");
        jedis.select(0);
    }

    @Test
    public void testString() {
        String result = jedis.set("name", "yuxuan");
        System.out.println("result : " + result);
        String name = jedis.get("name");
        System.out.println("name : " + name);
    }

    @Test
    public void testHash() {
        jedis.hset("user", "name", "yuxuan");
        jedis.hset("user", "age", "18");
        jedis.hset("user", "gender", "male");

        jedis.hgetAll("user")
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @AfterEach
    public void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
