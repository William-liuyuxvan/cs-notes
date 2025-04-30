package com.yuxuan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuxuan.mapper.LogMapper;
import com.yuxuan.pojo.LogQueryParam;
import com.yuxuan.pojo.OperateLog;
import com.yuxuan.pojo.PageResult;
import com.yuxuan.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 16:01
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 分页查询操作日志
     */
    @Override
    public PageResult<OperateLog> page(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());

        List<OperateLog> page = logMapper.page();

        Page<OperateLog> p = (Page<OperateLog>) page;

        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
