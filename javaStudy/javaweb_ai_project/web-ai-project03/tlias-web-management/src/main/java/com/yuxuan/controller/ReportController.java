package com.yuxuan.controller;

import com.yuxuan.pojo.JobOption;
import com.yuxuan.pojo.Result;
import com.yuxuan.pojo.StudentNumberOption;
import com.yuxuan.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ReportController
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 11:28
 */
@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 员工职位统计
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("员工职位统计");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }


    /**
     * 员工性别统计
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("员工性别统计");
        List<Map> list = reportService.getEmpGenderData();
        return Result.success(list);
    }

    /**
     * 班级人数统计
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("班级人数统计");
        StudentNumberOption studentNumberOption = reportService.getStudentCountData();
        return Result.success(studentNumberOption);
    }

    /**
     * 5.3 学员学历统计studentDegreeData
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        log.info("学员学历统计");
        List<Map> list = reportService.getStudentDegreeData();
        return Result.success(list);
    }
}
