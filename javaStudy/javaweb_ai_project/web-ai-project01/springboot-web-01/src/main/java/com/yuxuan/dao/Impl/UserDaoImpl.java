package com.yuxuan.dao.Impl;

import cn.hutool.core.io.IoUtil;
import com.yuxuan.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/22 19:11
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> list() {
//        FileInputStream in = new FileInputStream(new File(""));
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        return lines;
    }
}
