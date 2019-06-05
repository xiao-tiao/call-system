package com.wf.service.system.impl;

import com.wf.dao.system.AuthDao;
import com.wf.entity.system.Auth;
import com.wf.service.system.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authService")
public class AuthServiceImpl implements AuthService
{

    @Autowired
    private AuthDao authDao;
    public void add(Auth auth) {
        auth.setStatus("正常");
        authDao.insert(auth);
    }

    public void delete(int id) {
        authDao.delete(id);
    }

    public void update(Auth auth) {
        authDao.update(auth);
    }

    public Auth searchOne(int id) {
        return authDao.findById(id);
    }

    public List<Auth> searchAll() {
        return authDao.findAll();
    }


    public void deleteByDid(int did)
    {
        authDao.deleteByDid(did);
    }
}
