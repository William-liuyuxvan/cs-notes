package com.yuxuan.controller;

import com.yuxuan.exception.NotNullException;
import com.yuxuan.exception.NullException;
import com.yuxuan.pojo.Clazz;
import com.yuxuan.pojo.ClazzQueryParam;
import com.yuxuan.pojo.PageResult;
import com.yuxuan.pojo.Result;
import com.yuxuan.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ClazzController
 * @Description 班级管理响应层
 * @Author eeekuu
 * @Date 2025/4/28 14:38
 */
@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询: {}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) throws NullException {
        log.info("添加班级: {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据ID查询班级
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("根据ID查询班级: {}", id);
        Clazz clazz = clazzService.selectById(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级信息: {}", clazz);
        clazzService.updateById(clazz);
        return Result.success();
    }

    /**
     * 根据ID删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws NotNullException {
        log.info("根据ID删除班级: {}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result list() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }

}
