package com.wf.service.system.impl;

import com.wf.dao.system.AuthDao;
import com.wf.dao.system.DepartmentDao;
import com.wf.dao.system.PostDao;
import com.wf.entity.system.Department;
import com.wf.service.system.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private AuthDao authDao;
    public void add(Department department) {

        departmentDao.insert(department);
    }

    public void remove(int id) {
        authDao.deleteByDid(id);
        postDao.deleteByDid(id);
        departmentDao.delete(id);
    }

    public void update(Department department) {
        departmentDao.update(department);
    }

    public Department searchOne(int id) {
       return departmentDao.findOne(id);
    }

    public List<Department> searchAll() {
        return departmentDao.findAll();
    }

    public Department searchOne(String dep) {
        return departmentDao.findOneByName(dep);
    }
}
