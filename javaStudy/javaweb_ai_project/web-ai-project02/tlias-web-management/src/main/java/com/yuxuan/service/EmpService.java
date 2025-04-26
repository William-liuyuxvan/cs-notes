package com.yuxuan.service;

import com.yuxuan.pojo.Emp;
import com.yuxuan.pojo.PageResult;
import org.springframework.stereotype.Service;

/**
 * 员工
 */
public interface EmpService {

    /**
     * 分页查询
     * @param page 页数
     * @param pageSize 每页展示数
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}
