package com.valid.dao;

import com.valid.pojo.Student;

import java.util.List;

public interface StudentMapper {
    // 查询所有的学生信息，以及对应老师的信息
    List<Student> getStudent();
}
