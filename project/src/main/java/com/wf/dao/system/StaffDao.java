package com.wf.dao.system;

import com.wf.entity.system.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffDao")
public interface StaffDao {
    public void insert(Staff staff);
    public void delete(int id);
    public void update(Staff staff);
    public Staff findOne(int id);
    public List<Staff> findAll();


}
