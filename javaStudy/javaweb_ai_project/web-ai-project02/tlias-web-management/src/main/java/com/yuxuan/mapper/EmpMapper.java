package com.yuxuan.mapper;

import com.yuxuan.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    // 原始方法
//    /**
//     * 查询总记录数
//     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//    /**
//     * 查询结构列表
//     * @param start 开始
//     * @param pageSize 每页展示条数
//     */
//    @Select("select e.*, d.name from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    // 借助PageHelper
    /**
     * 查询结构列表
     */
    @Select("select e.*, d.name from emp e left join dept d on e.dept_id = d.id order by e.update_time desc ")
    public List<Emp> list();
}
