package com.wf.service.manage.impl;

import com.wf.dao.manage.BusinesDao;
import com.wf.entity.manage.Busines;
import com.wf.service.manage.BusinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("businesService")
public class BusinesServiceImpl implements BusinesService {
    @Autowired
    private BusinesDao businesDao;
    public void insert(Busines busines) {
        businesDao.insert(busines);
    }

    public void delete(int id) {
        businesDao.delete(id);
    }

    public void update(Busines busines) {
            businesDao.update(busines);
    }

    public Busines findOne(Busines busines) {
        return businesDao.findBusines(busines);
    }

    public List<Busines> findAll() {
        return businesDao.findAll();
    }

    public Busines findById(int id) {
        return businesDao.findById(id);
    }
}
