package com.yuxuan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuxuan.mapper.EmpMapper;
import com.yuxuan.pojo.Emp;
import com.yuxuan.pojo.PageResult;
import com.yuxuan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Description 员工
 * @Author eeekuu
 * @Date 2025/4/26 17:45
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    // 原始方法
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        // 1. 查询总数
//        Long total = empMapper.count();
//
//        // 2. 查询每页结果
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.list(start, pageSize);
//
//        // 3. 封装
//        return new PageResult<>(total, empList);

    // 借助PageHelper
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 1. 利用PageHelper
        PageHelper.startPage(page, pageSize);

        // 2. 执行语句
        List<Emp> empList = empMapper.list();

        // 3. 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
