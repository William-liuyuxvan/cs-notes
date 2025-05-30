package com.yuxuan.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @ClassName ClazzQueryParam
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 14:42
 */
@Data
public class StudentQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer degree;
    private Integer clazzId;
}
