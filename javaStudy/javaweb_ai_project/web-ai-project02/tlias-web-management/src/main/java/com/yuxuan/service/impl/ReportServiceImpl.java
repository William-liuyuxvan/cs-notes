package com.yuxuan.service.impl;

import com.yuxuan.mapper.EmpMapper;
import com.yuxuan.mapper.StudentMapper;
import com.yuxuan.pojo.JobOption;
import com.yuxuan.pojo.StudentNumberOption;
import com.yuxuan.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ReportServiceImpl
 * @Description 数据访问
 * @Author eeekuu
 * @Date 2025/4/28 11:30
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        // 1. 调用mapper
        List<Map<String, Object>> list = empMapper.countEmpJobData();

        // 2. 封装数据
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public StudentNumberOption getStudentCountData() {
        // 1. 调用mapper
        List<Map<String, Object>> mapList = studentMapper.getStudentCountData();

        // 2. 封装数据
        List<Object> clazzData = mapList.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> numData = mapList.stream().map(dataMap -> dataMap.get("num")).toList();

        return new StudentNumberOption(clazzData, numData);
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }
}
