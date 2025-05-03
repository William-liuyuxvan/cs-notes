package com.yuxuan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuxuan.mapper.StudentMapper;
import com.yuxuan.pojo.PageResult;
import com.yuxuan.pojo.Student;
import com.yuxuan.pojo.StudentQueryParam;
import com.yuxuan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 16:50
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        // 1. PageHelper
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        // 2. 调用mapper
        List<Student> studentList = studentMapper.page(studentQueryParam);

        Page<Student> p = (Page<Student>) studentList;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Student student) {
        // 1. 添加基础信息
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());

        // 2. 调用mapper
        studentMapper.save(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        // 1. 修改基础信息
        student.setUpdateTime(LocalDateTime.now());

        // 2. 调用mapper
        studentMapper.update(student);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void setViolation(Integer id, Integer score) {
        studentMapper.setViolation(id, score);
    }


}
