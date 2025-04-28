package com.yuxuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName JobOption
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 11:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {

    private List jobList; // 职位列表
    private List dataList; // 人数列表
}
