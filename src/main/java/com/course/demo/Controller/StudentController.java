package com.course.demo.Controller;

import com.course.demo.Entity.Result;
import com.course.demo.Entity.Student;
import com.course.demo.Service.StudentService;
import com.course.demo.Util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.collections.ListUtils;


import java.util.List;

@Controller
@Api(value = "-API", tags = { "学生接口" })
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation("获取所有学生信息")
    @ResponseBody
    @PostMapping("/select")
    public Result<Object> selectAllStudent()
    {
        List<Student> students=studentService.select();
        List<Student> students1=studentService.select1();
        List<Student> students2=ListUtils.sum(students,students1);
        return ResultUtil.success(students2);
    }

}
