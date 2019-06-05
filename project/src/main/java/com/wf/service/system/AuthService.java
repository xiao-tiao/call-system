package com.wf.service.system;

import com.wf.entity.system.Auth;
import com.wf.entity.system.Post;

import java.util.List;

public interface AuthService {
    public void add(Auth auth);
    public void delete(int id);
    public void update(Auth auth);
    public Auth searchOne(int id);
    public List<Auth> searchAll();
    public  void deleteByDid(int did);

}
