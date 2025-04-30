package com.yuxuan.mapper;

import com.yuxuan.pojo.LogQueryParam;
import com.yuxuan.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName LogMapper
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 16:01
 */
@Mapper
public interface LogMapper {

    @Select("select * from operate_log")
    List<OperateLog> page();
}
