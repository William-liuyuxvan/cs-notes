package com.yuxuan.controller;

import com.yuxuan.pojo.PageResult;
import com.yuxuan.pojo.Result;
import com.yuxuan.pojo.Student;
import com.yuxuan.pojo.StudentQueryParam;
import com.yuxuan.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName StudentController
 * @Description 学生控制器层
 * @Author eeekuu
 * @Date 2025/4/28 16:50
 */
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 分页查询所有学生
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam)  {
        log.info("分页查询所有学生");
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加学生
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("添加学生: {}", student);
        studentService.save(student);
        return Result.success();
    }

    /**
     * 根据ID查询学生
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询学生: {}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /**
     * 修改学生信息
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生信息: {}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 根据ID批量删除学生
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("根据ID批量删除学生: {}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("违纪处理: {}, {}", id, score);
        studentService.setViolation(id, score);
        return Result.success();
    }
}
