package com.qf.test;

import com.qf.dao.TeacherMapper;
import com.qf.pojo.Teacher;
import com.qf.service.impl.TeacherServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestSelectAll {
    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //使用sqlSession对象加载你要执行的接口
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectAll();
        System.out.println("teachers = " + teachers);
    }

    @Test
    public void testUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //使用sqlSession对象加载你要执行的接口
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setTeacherName("2老师");
        teacher.setId(3);
        int update = mapper.updateTeacher(teacher);
        System.out.println(update);
    }

    @Test
    public void testInsert() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //使用sqlSession对象加载你要执行的接口
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setTeacherName("2老师");
        teacher.setTeacherAddr("南窑头");
        teacher.setAge(15);
        int update = mapper.insertTeacher(teacher);
        System.out.println(update);
    }

}
