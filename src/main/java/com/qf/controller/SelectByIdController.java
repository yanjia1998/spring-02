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

@WebServlet("/selectById")
public class SelectByIdController extends HttpServlet {

    private TeacherService teacherService;
    static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring-context.xml");
    @Override
    public void init(ServletConfig config) throws ServletException {
        teacherService = (TeacherService)cpx.getBean("teacherService");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id")) ;
        Teacher teacher = teacherService.selectById(id);
        req.setAttribute("teacher",teacher);
        req.getRequestDispatcher("selectById.jsp").forward(req,resp);
    }
}
