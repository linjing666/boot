package com.light.spring.Service;

import com.light.spring.Dao.DepartmentMapper;
import com.light.spring.Entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public void insert(Department department){
        this.departmentMapper.insert(department);

    }
}
