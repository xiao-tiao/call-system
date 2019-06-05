package com.wf.dao;

import com.wf.entity.system.Staff;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {
    public Staff login(String account);
}
