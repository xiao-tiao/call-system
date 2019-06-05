package com.wf.dao.manage;

import com.wf.entity.manage.Busines;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("businesDao")
public interface BusinesDao {

    public void insert(Busines busines);
    public void delete(int id);
    public void update(Busines busines);
    public List<Busines> findAll();
    public Busines findBusines(Busines busines);
    public Busines findById(int id);
}
