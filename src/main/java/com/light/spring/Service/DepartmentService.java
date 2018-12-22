package com.light.spring.Service;

import com.light.spring.Entity.Department;

import java.util.List;

public interface DepartmentService {
    public void insert(Department department);

    List<Department> getAll();
}
