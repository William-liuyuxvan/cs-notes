package com.yuxuan.controller;

import com.yuxuan.pojo.Dept;
import com.yuxuan.pojo.Result;
import com.yuxuan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/25 15:31
 */
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        List<Dept> deptList = deptService.findAll();

        return Result.success(deptList);
    }

      // 方法一
//    @DeleteMapping("/depts")
//    public Result deleteById(HttpServletRequest request) {
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("删除部分id：" + id);
////        deptService.deleteById(id);
//        return Result.success();
//    }
      // 方法二
//    @DeleteMapping("/depts")
//    public Result deleteById(@RequestParam("id") Integer deptId) {
//        System.out.println("删除部分id：" + deptId);
////        deptService.deleteById(deptId);
//        return Result.success();
//    }

    // 方法三
    @DeleteMapping
    public Result deleteById(Integer id) {
        System.out.println("删除部分id：" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        System.out.println("新增部门：" + dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        System.out.println("查询的部门ID ：" + id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门信息：" + dept);
        deptService.updateById(dept);
        return Result.success();
    }

}
