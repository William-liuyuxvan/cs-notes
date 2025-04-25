package com.yuxuan.mapper;

import com.yuxuan.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     */
//    @Results({
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select id, name, create_time createTime, update_time updateTime from dept")
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void deleteById(int id);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept findById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}
