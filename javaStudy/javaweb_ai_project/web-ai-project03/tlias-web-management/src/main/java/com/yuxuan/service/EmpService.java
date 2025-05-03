package com.yuxuan.service;

import com.yuxuan.pojo.Emp;
import com.yuxuan.pojo.EmpQueryParam;
import com.yuxuan.pojo.LoginInfo;
import com.yuxuan.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工
 */
public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 添加员工
     */
    void save(Emp emp);

    /**
     * 根据员工ID批量删除信息
     */
    void deleteById(List<Integer> ids);

    /**
     * 根据员工ID查询员工信息
     */
    Emp getInfo(Integer id);

    /**
     * 更新员工信息
     */
    void update(Emp emp);

    /**
     * 查询所有员工
     */
    List<Emp> listAllEmp();

    LoginInfo login(Emp emp);
}
