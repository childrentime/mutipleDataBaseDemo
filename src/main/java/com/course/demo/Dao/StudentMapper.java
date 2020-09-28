package com.course.demo.Dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.course.demo.Entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select * from student")
    List<Student> select();

    @DS("slave_1")
    @Select("select * from student ")
    @Results({
            @Result( id = true ,property = "student_id", column = "studentId"),
            @Result(property="student_name" ,column="studentName"),
            @Result(property="student_sex", column="studentSex"),
    })
    List<Student> select1();
}
