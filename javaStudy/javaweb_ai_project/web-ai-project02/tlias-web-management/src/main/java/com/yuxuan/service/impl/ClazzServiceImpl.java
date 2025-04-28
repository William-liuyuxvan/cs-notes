package com.yuxuan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuxuan.exception.NotNullException;
import com.yuxuan.exception.NullException;
import com.yuxuan.mapper.ClazzMapper;
import com.yuxuan.mapper.StudentMapper;
import com.yuxuan.pojo.Clazz;
import com.yuxuan.pojo.ClazzQueryParam;
import com.yuxuan.pojo.PageResult;
import com.yuxuan.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/28 14:39
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        // 1. PageHelper
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        // 2. 调用mapper查询
        List<Clazz> page = clazzMapper.page(clazzQueryParam);

        // 3. 封装数据
        Page<Clazz> p = (Page<Clazz>) page;

        LocalDate now = LocalDate.now();

        p.getResult().forEach(clazz -> {
            if (now.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else if (now.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读中");
            }
        });

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Clazz clazz) throws NullException {
        // 1. 抛出异常
        if (clazz.getRoom() == null || clazz.getRoom().isEmpty()) throw new NullException("教室不能为空");

        // 2. 添加基础信息
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        // 3. 调用mapper
        clazzMapper.save(clazz);
    }

    @Override
    public Clazz selectById(Integer id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void updateById(Clazz clazz) {
        // 1. 修改基础数据
        clazz.setUpdateTime(LocalDateTime.now());

        // 2. 调用mapper
        clazzMapper.updateById(clazz);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) throws NotNullException {
        // 1. 检查该班级下是否还有学生
        Integer count = studentMapper.countByClazzId(id);
        if (count > 0) throw new NotNullException("还有学生，无法删除");

        // 2. 调用mapper删除班级
        clazzMapper.deleteById(id);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.list();
    }
}
