package com.yuxuan.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName EmpExpr
 * @Description 员工工作经历
 * @Author eeekuu
 * @Date 2025/4/26 17:41
 */
@Data
public class EmpExpr {
    private Integer id; //ID
    private Integer empId; //员工ID
    private LocalDate begin; //开始时间
    private LocalDate end; //结束时间
    private String company; //公司名称
    private String job; //职位
}