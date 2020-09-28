package com.course.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.course.demo.Entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> select();
    List<Student> select1();
}
