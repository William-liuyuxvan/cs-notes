package com.yuxuan.service;

import com.yuxuan.pojo.PageResult;
import com.yuxuan.pojo.Student;
import com.yuxuan.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    /**
     * 分页查询学生信息
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 添加学生
     */
    void save(Student student);

    /**
     * 根据ID查询学生
     */
    Student getById(Integer id);

    /**
     * 修改学生信息
     */
    void update(Student student);

    /**
     * 根据ID批量删除学生
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 违纪处理
     */
    void setViolation(Integer id, Integer score);
}
