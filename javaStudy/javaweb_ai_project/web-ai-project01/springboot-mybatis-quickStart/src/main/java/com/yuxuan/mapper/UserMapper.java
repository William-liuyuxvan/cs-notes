package com.yuxuan.mapper;

import com.yuxuan.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询全部
     */
//    @Select("select * from user")
    public List<User> findAll();

    /**
     * 指定id删除用户
     */
    @Delete("delete from user where id = #{id}")
    public Integer deleteById(int id);

    /**
     * 添加数据
     */
    @Insert("insert into user(username,password,name,age) values (#{username},#{password},#{name},#{age})")
    public Integer insert(User user);

    /**
     * 更新数据
     */
    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public Integer updateById(User user);

    /**
     * 通过账号和密码查找数据
     */
    @Select({"select * from user where username = #{username} and password = #{password}"})
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
