package com.wf.service.system.impl;

import com.wf.dao.system.PostDao;
import com.wf.dao.system.StaffDao;
import com.wf.entity.system.Post;
import com.wf.entity.system.Staff;
import com.wf.service.system.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private PostDao postDao;
    //增加Staff  将staff表的增加和post表的更新都放在业务层
    //为了后期事务处理方便
    public void add(Staff staff) {
        staff.setWorkTime(new Date());
        staff.setStatus("锁定");
        staffDao.insert(staff);
        if(staff.getPost()==null)
        {

        }
        else
        {
            for(Post post:staff.getPost())
            {
                post.setSid(staff.getId());
                postDao.insert(post);
            }
        }

    }

    public void delete(int id) {
        postDao.deleteBySid(id);
        staffDao.delete(id);
    }

    public void update(Staff staff) {
        postDao.deleteBySid(staff.getId());
        for(Post post:staff.getPost())
        {
            postDao.insert(post);
        }
        staffDao.update(staff);

    }


    public Staff searchOne(int id) {
        return staffDao.findOne(id);
    }


    public List<Staff> searchAll() {

        return staffDao.findAll();
    }

    public void updateStatus(Staff staff) {
        staffDao.update(staff);
    }
}
