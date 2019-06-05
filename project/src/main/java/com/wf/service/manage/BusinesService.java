package com.wf.service.manage;

import com.wf.entity.manage.Busines;

import java.util.List;

public interface BusinesService {
    public void insert(Busines busines);
    public void delete(int id);
    public void update(Busines busines);
    public Busines findOne(Busines busines);
    public List<Busines> findAll();
    public Busines findById(int id);
}
