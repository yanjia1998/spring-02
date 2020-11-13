package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

@WebServlet("/selectAll")
public class SelectAllConrtoller extends HttpServlet {

    private TeacherService teacherService;
    static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring-context.xml");
    @Override
    public void init(ServletConfig config) throws ServletException {
        teacherService = (TeacherService)cpx.getBean("teacherService");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNum = req.getParameter("pageNum")!= null ?Integer.valueOf(req.getParameter("pageNum")):1;
        PageHelper.startPage(pageNum,9);

        List<Teacher> teachers = teacherService.selectAll();
        PageInfo<Teacher> pageinfo = new PageInfo<Teacher>(teachers);

        req.setAttribute("teachers",teachers);
        req.setAttribute("pageinfo",pageinfo);
        req.getRequestDispatcher("selectAll.jsp").forward(req,resp);
    }
}
