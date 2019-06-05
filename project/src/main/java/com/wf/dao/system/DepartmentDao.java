package com.wf.dao.system;

import com.wf.entity.system.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(int id);
    void update(Department department);
     Department findOne(int id);
     List<Department> findAll();
     Department findOneByName(String dep);
}
