package com.yuxuan.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName JedisConnectionPool
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/5/14 20:15
 */
public class JedisConnectionFactory {
    private static JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(8);
        jedisPoolConfig.setMaxWaitMillis(1000);
        // 连接池连接
        jedisPool = new JedisPool(jedisPoolConfig,
                "192.168.100.128", 6379, 1000, "123321");
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
