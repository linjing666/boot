package com.light.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.light.spring.Dao.RedisDao;
import com.light.spring.Entity.Department;
import com.light.spring.Service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @PostMapping ("/helloworld")
    public PageInfo<Department> hello2(Integer PageNum,Integer PageSize){

        PageHelper.startPage(PageNum,PageSize);
        List<Department> list=departmentServiceImpl.getAll();
        for (Department i: list
             ) {
            System.out.println(i);
        }
        PageInfo<Department> pageInfo = new PageInfo<Department>(list);
        return  pageInfo;
    }


    @GetMapping("/helloworld1")
    public String hello1(){
        Department department=new Department();
        for (int i=0;i<100;i++){
            String name="Mapper"+i;
            String descr="Descr"+i*10;
            department.setName(name);
            department.setDescr(descr);
            this.departmentServiceImpl.insert(department);
        }
        return "yes";
    }
}
