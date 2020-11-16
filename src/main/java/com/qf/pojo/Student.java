package com.qf.pojo;

import lombok.Data;

import java.util.*;

@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Date birthday;
    private String[] hobbys;
    private Set<String> phones;
    private List<String> girlNames;
    private Map<String,String> countries;
    private Properties files;
    private Teacher teacher;

}
