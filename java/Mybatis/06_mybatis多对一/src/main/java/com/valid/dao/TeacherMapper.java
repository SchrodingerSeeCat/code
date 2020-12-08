package com.valid.dao;


import com.valid.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    // 获取指定老师的信息，及其所对应的学生
    Teacher getTeacher(@Param("tid") int id);
}
