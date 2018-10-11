package com.light.spring.controller;

import com.light.spring.Dao.RedisDao;
import com.light.spring.Entity.Department;
import com.light.spring.Service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller  {
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;
    @Autowired
    private RedisDao redisDao;
    @GetMapping("/helloworld2")
    public String hello(String Desrc , String Name){
        Department department=new Department();

        department.setDescr(Desrc);
        department.setName(Name);
        this.departmentServiceImpl.insert(department);
        redisDao.set(Name,"1");
        return "yes";
    }
    @GetMapping("/helloworld")
    public String hello2(){
        return "hello world";
    }
    @GetMapping("/helloworld1")
    public String hello1(String name){
        String i=redisDao.get(name);
        System.out.println(i);
        return  i;
    }
}
