package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.TeacherMapper;
import com.qf.pojo.Teacher;
import com.qf.service.TeacherService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
            return  mapper.selectAll();
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
            return mapper.selectById(id);

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
            return   mapper.updateTeacher(teacher);

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
            return mapper.delTeacherById(id);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
