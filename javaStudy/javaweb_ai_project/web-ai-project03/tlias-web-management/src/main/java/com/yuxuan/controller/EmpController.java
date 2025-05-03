package com.yuxuan.controller;

import com.yuxuan.pojo.Emp;
import com.yuxuan.pojo.EmpQueryParam;
import com.yuxuan.pojo.PageResult;
import com.yuxuan.pojo.Result;
import com.yuxuan.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName EmpController
 * @Description 员工
 * @Author eeekuu
 * @Date 2025/4/26 17:46
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询参数: {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("添加员工参数: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 删除员工
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工：{}", ids);
        empService.deleteById(ids);
        return Result.success();
    }

    /**
     * 根据员工ID查询信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据员工ID查询信息：{}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 更新员工信息
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工信息：{}", emp);
        empService.update(emp);
        return Result.success();
    }

    /**
     * 查询所有员工
     */
    @GetMapping("/list")
    public Result list() {
        List<Emp> empList = empService.listAllEmp();
        return Result.success(empList);
    }
}
