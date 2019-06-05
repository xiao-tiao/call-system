package com.wf.dao;

import com.wf.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("logDao")
public interface LogDao {
    public void insert(Log log);
    public List<Log> searchByType(String type);
}
