package com.yuxuan.service;

import com.yuxuan.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有员工
     */
    List<Dept> findAll();

    /**
     * 根据id删除数据
     */
    void deleteById(int id);

    /**
     * 新增部门
     */
    void add(Dept dept);

    /**
     * 根据ID查询部门
     */
    Dept findById(Integer id);

    /**
     * 根据ID修改部门信息
     */
    void updateById(Dept dept);
}
