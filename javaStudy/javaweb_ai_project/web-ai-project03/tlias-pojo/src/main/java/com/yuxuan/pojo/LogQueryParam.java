package com.yuxuan.pojo;

import lombok.Data;

/**
 * @ClassName LogQueryParam
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/30 15:59
 */
@Data
public class LogQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
}
