package com.yuxuan;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTest
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/29 18:45
 */
public class JwtTest {


    @Test
    public void testGenJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", "admin");
        dataMap.put("password", "123456");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRoZWltYQ==")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        String str = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoiYWRtaW4iLCJleHAiOjE3NDU5Mjc2NzR9.RbLJf42jZ4l2Kp7gMAJJaBrMKthbT652C7RTC1DQYo0";
        Claims claims = Jwts.parser().setSigningKey("aXRoZWltYQ==")
                .parseClaimsJws(str)
                .getBody();
        System.out.println(claims);
    }
}
