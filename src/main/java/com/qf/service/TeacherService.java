package com.qf.service;

import com.qf.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {


    List<Teacher> selectAll();

    Teacher selectById(@Param("id")Integer id);

    int updateTeacher(Teacher teacher);

    int delTeacherById(@Param("id")Integer id);
}
