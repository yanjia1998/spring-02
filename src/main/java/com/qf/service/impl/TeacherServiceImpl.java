package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.TeacherMapper;
import com.qf.pojo.Teacher;
import com.qf.service.TeacherService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Component(value = "teacherService")
public class TeacherServiceImpl implements TeacherService {
    static SqlSessionFactory sqlSessionFactory = null;
    static String resource = "mybatis-config.xml";

    @Override
    public List<Teacher> selectAll() {

        InputStream inputStream = null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            ;
//            PageInfo<Teacher> pageInfo = new PageInfo<>()
            List<Teacher> teachers = mapper.selectAll();
            sqlSession.close();
            return teachers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher selectById(Integer id) {
        InputStream inputStream = null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.selectById(id);
            sqlSession.close();
            return teacher;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        InputStream inputStream = null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            int i = mapper.updateTeacher(teacher);
            sqlSession.close();
            return i;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delTeacherById(Integer id) {
        InputStream inputStream = null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            int i = mapper.delTeacherById(id);
            sqlSession.close();
            return i;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        InputStream inputStream = null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            int i = mapper.insertTeacher(teacher);
            sqlSession.close();
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
