package com.yuxuan.service.impl;

import com.yuxuan.exception.NotNullException;
import com.yuxuan.mapper.DeptMapper;
import com.yuxuan.mapper.EmpMapper;
import com.yuxuan.pojo.Dept;
import com.yuxuan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(int id) throws NotNullException {
        // 1. 检查是否有员工关联
        if (empMapper.findByDeptId(id) > 0) {
            throw new NotNullException("对不起，当前部门下有员工，不能直接删除！");
        }

        // 2. 调用mapper
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
