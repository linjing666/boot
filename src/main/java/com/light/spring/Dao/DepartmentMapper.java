package com.light.spring.Dao;

import com.light.spring.Entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface DepartmentMapper {

    public void insert(Department department);

    public Department getById(Integer id);

    public List<Department> getAll();

    public void update(Department department);

    public void deleteById(Integer id);
}