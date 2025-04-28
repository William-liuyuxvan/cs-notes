package com.yuxuan.service;

import com.yuxuan.exception.NotNullException;
import com.yuxuan.exception.NullException;
import com.yuxuan.pojo.Clazz;
import com.yuxuan.pojo.ClazzQueryParam;
import com.yuxuan.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    /**
     * 分页查询
     */
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 添加班级
     */
    void save(Clazz clazz) throws NullException;

    /**
     * 根据ID查询班级
     */
    Clazz selectById(Integer id);

    /**
     * 根据ID更新数据
     */
    void updateById(Clazz clazz);

    /**
     * 根据ID删除班级
     */
    void deleteById(Integer id) throws NotNullException;

    /**
     * 查询所有班级
     */
    List<Clazz> list();
}
