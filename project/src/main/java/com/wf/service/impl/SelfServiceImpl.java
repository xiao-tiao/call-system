package com.wf.service.impl;

import com.wf.dao.SelfDao;
import com.wf.dao.system.StaffDao;
import com.wf.entity.system.Staff;
import com.wf.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfDao selfDao;

    @Autowired
    private StaffDao staffDao;

    public Staff login(String account, String password) {
        Staff staff=selfDao.login(account);
        if(staff==null) return null;
        if(staff.getPassword().equals(password)) return staff;
        return null;
    }

    public void changePass(int id, String password) {
            Staff staff=staffDao.findOne(id);
            staff.setPassword(password);
            staffDao.update(staff);
    }
}
