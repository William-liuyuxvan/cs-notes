package com.yuxuan.controller;

import com.yuxuan.pojo.LogQueryParam;
import com.yuxuan.pojo.OperateLog;
import com.yuxuan.pojo.PageResult;
import com.yuxuan.pojo.Result;
import com.yuxuan.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 16:00
 */
@Slf4j
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询
     */
    @GetMapping("/log/page")
    public Result page(LogQueryParam logQueryParam)  {
        log.info("logQueryParam:{}", logQueryParam);
        PageResult<OperateLog> pageResult = logService.page(logQueryParam);
        return Result.success(pageResult);
    }
}
