package com.qf.test;

import com.qf.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testioc {
    @Test
    public void testIoc(){
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring-context.xml");
        Student student = (Student)cpx.getBean("student");
        System.out.println(student);
    }
}
