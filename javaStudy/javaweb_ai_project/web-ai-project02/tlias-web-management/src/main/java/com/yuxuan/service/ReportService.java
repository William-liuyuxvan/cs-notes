package com.yuxuan.service;

import com.yuxuan.pojo.JobOption;
import com.yuxuan.pojo.StudentNumberOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();

    StudentNumberOption getStudentCountData();

    List<Map> getStudentDegreeData();
}
