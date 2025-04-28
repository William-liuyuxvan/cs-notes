package com.yuxuan.mapper;

import com.yuxuan.pojo.Emp;
import com.yuxuan.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

    // 原始方法
//    /**
//     * 查询总记录数
//     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//    /**
//     * 查询结构列表
//     * @param start 开始
//     * @param pageSize 每页展示条数
//     */
//    @Select("select e.*, d.name from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    // 借助PageHelper
    /**
     * 查询结构列表
     */
//    @Select("select e.*, d.name from emp e left join dept d on e.dept_id = d.id order by e.update_time desc ")
    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 保存员工基本信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "    values(#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    void deleteById(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("name")
    List<Map> countEmpGenderData();

    @Select("select * from emp")
    List<Emp> listAllEmp();

    @Select("select count(*) from emp where dept_id = #{id}")
    Integer findByDeptId(int id);
}
