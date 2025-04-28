package com.yuxuan.mapper;

import com.yuxuan.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {
    /**
     * 批量添加工作经历
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 批量删除工作经历
     */
    void deleteByEmpId(List<Integer> empIds);
}
