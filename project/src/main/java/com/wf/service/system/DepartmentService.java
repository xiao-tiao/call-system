package com.wf.service.system;

import com.wf.entity.system.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void remove(int id);
    void update(Department department);
    Department searchOne(int id);
    List<Department> searchAll();

    Department searchOne(String dep);
}
