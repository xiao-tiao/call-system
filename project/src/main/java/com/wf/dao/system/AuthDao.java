package com.wf.dao.system;

import com.wf.entity.system.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("authDao")
public interface AuthDao {
    public void insert(Auth auth);
    public void delete(int id);
    public void update(Auth auth);
    public Auth  findById(int id);
    public List<Auth> findAll();
    public void deleteByDid(int did);
    public void deleteByFid(int did);
}
