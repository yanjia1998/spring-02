package com.qf.controller;

import com.qf.pojo.Teacher;
import com.qf.service.TeacherService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class InsertTeacherController extends HttpServlet {
    private TeacherService teacherService;
    static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring-context.xml");
    @Override
    public void init(ServletConfig config) throws ServletException {
        teacherService = (TeacherService)cpx.getBean("teacherService");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String teacherName = req.getParameter("teacherName");
        String teacherAddr = req.getParameter("teacherAddr");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Teacher teacher = (Teacher) cpx.getBean("teacher");
        teacher.setTeacherName(teacherName);
        teacher.setTeacherAddr(teacherAddr);
        teacher.setAge(age);
        int i = teacherService.insertTeacher(teacher);
        if( i > 0){
            resp.sendRedirect("selectAll");
        }
    }
}
