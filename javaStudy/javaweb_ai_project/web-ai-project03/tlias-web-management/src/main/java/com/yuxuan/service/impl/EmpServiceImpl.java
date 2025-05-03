package com.yuxuan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuxuan.mapper.EmpExprMapper;
import com.yuxuan.mapper.EmpMapper;
import com.yuxuan.pojo.*;
import com.yuxuan.service.EmpService;
import com.yuxuan.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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

    @Autowired
    private EmpExprMapper empExprMapper;

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
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 1. 利用PageHelper
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2. 执行语句
        List<Emp> empList = empMapper.list(empQueryParam);

        // 3. 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class}) // 事务管理 - 回滚
    @Override
    public void save(Emp emp) {
        // 1. 添加基础信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        // 2. 保存员工基本信息
        empMapper.insert(emp);

        // 3. 保存员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(expr -> {
                expr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }


    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteById(List<Integer> ids) {
        // 1. 删除员工信息
        empMapper.deleteById(ids);

        // 2. 删除员工工作经历信息
        empExprMapper.deleteByEmpId(ids);

    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getInfo(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        // 1. 跟新员工信息
        empMapper.update(emp);

        // 2. 更新员工工作经历信息
        // 2.1 删除员工工作经历信息
        empExprMapper.deleteByEmpId(Collections.singletonList(emp.getId()));

        // 2.2 添加员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (exprList != null && !exprList.isEmpty()) {
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public List<Emp> listAllEmp() {
        return empMapper.listAllEmp();
    }

    @Override
    public LoginInfo login(Emp emp) {
        // 1. 查询数据
        Emp user = empMapper.seleteUsernameAndPassword(emp);

        // 2. 判断是否正确
        if (user != null) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("id", user.getId());
            dataMap.put("username", user.getUsername());

            String jwt = JwtUtils.generateJwt(dataMap);

            return new LoginInfo(user.getId(), user.getUsername(), user.getName(), jwt);
        }

        return null;
    }


}
