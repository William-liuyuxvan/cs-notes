package com.yuxuan.mapper;

import com.yuxuan.pojo.Student;
import com.yuxuan.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /**
     * 分页查询所有学生
     */
    List<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 添加学生信息
     */
    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_time, update_time) " +
            " values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void save(Student student);

    /**
     * 根据ID查询学生信息
     */
    @Select("select * from student where id = #{id}")
    Student getById(Integer id);

    /**
     * 更新学生信息
     */
    void update(Student student);

    /**
     * 根据ID批量删除学生信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 设置违规次数和违规分数
     */
    @Update("UPDATE student set violation_count = violation_count + 1, violation_score = violation_score + #{score} WHERE id = #{id}")
    void setViolation(Integer id, Integer score);

    /**
     * 获取班级人数统计信息
     */
    @Select("select c.name, count(*) num from student s left join clazz c on c.id = s.clazz_id group by s.clazz_id order by num")
    List<Map<String, Object>> getStudentCountData();

    /**
     * 获取学生学位统计信息
     */
    @MapKey("name")
    List<Map> getStudentDegreeData();

    /**
     * 根据班级ID查询学生数量
     * @param id
     * @return
     */
    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countByClazzId(Integer id);
}
