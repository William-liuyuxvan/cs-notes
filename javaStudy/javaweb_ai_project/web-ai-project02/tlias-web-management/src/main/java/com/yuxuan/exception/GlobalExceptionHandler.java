package com.yuxuan.exception;

import com.yuxuan.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理器
 * @Author eeekuu
 * @Date 2025/4/28 9:27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handlerException(Exception e) {
        log.error("程序出错了：", e);
        return Result.error("出错啦，请联系管理员~    ");
    }

    @ExceptionHandler
    public Result handlerDuplicateKeyException(DuplicateKeyException e) {
        log.error("程序出错了：", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + " 已存在");
    }

    @ExceptionHandler
    public Result handlerNullException(NullException e) {
        log.error("程序出错了：", e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler
    public Result handlerNotNullException(NotNullException e) {
        log.error("程序出错了：", e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler
    public Result handlerDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("程序出错了：", e);
        String message = e.getMessage();
        int i = message.indexOf("Column");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");

        switch (arr[1]) {
            case "'clazz_id'":
                return Result.error("所属班级不能为空");
            default:
                return Result.error(arr[1] + " 不能为空");
        }
    }
}
