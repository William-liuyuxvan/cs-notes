package com.yuxuan;

import com.yuxuan.mapper.UserMapper;
import com.yuxuan.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteById(){
        Integer i = userMapper.deleteById(5);
        System.out.println("testDeleteById: " + i);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "zhouyu", "123456", "周瑜", 20);
        Integer i = userMapper.insert(user);
        System.out.println("testInsert: " + i);
    }

    @Test
    public void testUpdateById(){
        User user = new User(6, "zhouyu", "123456", "周瑜", 25);
        Integer i = userMapper.updateById(user);
        System.out.println("testUpdateById: " + i);
    }

    @Test
    public void testFindUserByUsernameAndPassword(){
        User user = userMapper.findUserByUsernameAndPassword("zhouyu", "123456");
        System.out.println(user);
    }
}
