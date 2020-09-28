package com.course.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Student {
    @TableId
    private  Integer student_id;
    private  String student_name;
    private  String student_sex;

}
