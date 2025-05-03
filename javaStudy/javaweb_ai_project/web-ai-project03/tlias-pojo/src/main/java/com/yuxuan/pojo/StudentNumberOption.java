package com.yuxuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName StudentNumberOption
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 20:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentNumberOption {
    private List clazzList;
    private List dataList;
}
