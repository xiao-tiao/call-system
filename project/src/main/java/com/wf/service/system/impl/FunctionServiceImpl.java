package com.wf.service.system.impl;

import com.wf.dao.system.AuthDao;
import com.wf.dao.system.FunctionDao;
import com.wf.entity.system.Auth;
import com.wf.entity.system.Function;
import com.wf.service.system.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("fuctionService")
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionDao functionDao;

    @Autowired
    private AuthDao authDao;
    public void add(Function function) {
        functionDao.insert(function);
    }



    public void update(Function function) {
        functionDao.update(function);
    }

    public Function searchOne(int id) {
        return functionDao.findById(id);
    }

    public List<Function> searchAll() {
        return functionDao.findAll();
    }

    public List<Function> findRoot() {
        return functionDao.findByAccordion(0);
    }

    public List<Function> findOther() {
        return functionDao.findByAccordion(1);
    }

    public List<Function> findByParentId(int id) {
        return functionDao.findByParentId(id);
    }


    public void delete(int id) {
      List<Function>  function= functionDao.findByParentId(id);
      for(Function f:function)
      {
          delete(f.getId());
      }
      functionDao.delete(id);
      authDao.deleteByFid(id);

    }
}
