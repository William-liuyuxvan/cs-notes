package com.yuxuan.service.impl;

import com.yuxuan.mapper.DeptMapper;
import com.yuxuan.pojo.Dept;
import com.yuxuan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/25 15:31
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(int id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        // 1. 添加时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 2. 调用mapper
        deptMapper.add(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public void updateById(Dept dept) {
        // 1. 添加基础代码
        dept.setUpdateTime(LocalDateTime.now());
        // 2. 调用mapper
        deptMapper.updateById(dept);
    }
}
