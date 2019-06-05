package com.wf.service;

import com.wf.entity.system.Staff;

public interface SelfService {

    public Staff login(String account,String password);

    public void changePass(int id,String password);
}
