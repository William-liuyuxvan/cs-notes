package com.yuxuan.mapper;

import com.yuxuan.pojo.Clazz;
import com.yuxuan.pojo.ClazzQueryParam;
import com.yuxuan.pojo.PageResult;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {


    /**
     * 分页查询
     */
    List<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 添加班级
     */
    @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void save(Clazz clazz);

    /**
     * 根据ID查询班级
     */
    @Select("select * from clazz where id = #{id}")
    Clazz selectById(Integer id);

    void updateById(Clazz clazz);

    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from clazz")
    List<Clazz> list();
}
