package com.course.demo.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.course.demo.Dao.StudentMapper;
import com.course.demo.Entity.Student;
import com.course.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student>implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> select() {
        return  studentMapper.select();
    }

    @Override
    public List<Student> select1() {

        return studentMapper.select1();
    }
}
