package com.yuxuan.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @ClassName EmpQueryParam
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/27 12:08
 */
@Data
public class EmpQueryParam {
    Integer page = 1;
    Integer pageSize = 10;
    String name;
    Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate end;
}
