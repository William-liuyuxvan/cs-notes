package com.yuxuan.service;

import com.yuxuan.pojo.LogQueryParam;
import com.yuxuan.pojo.OperateLog;
import com.yuxuan.pojo.PageResult;

import java.util.List;

public interface LogService {

    /**
     * 分页查询操作日志
     */
    PageResult<OperateLog> page(LogQueryParam logQueryParam);
}
