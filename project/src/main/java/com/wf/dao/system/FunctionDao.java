package com.wf.dao.system;

import com.wf.entity.system.Function;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("functionDao")
public interface FunctionDao {
    public void insert(Function function);
    public void delete(int id);
    public void update(Function function);
    public Function findById(int id);
    public List<Function> findAll();
    public List<Function> findByAccordion(int accordion);
    public List<Function> findByParentId(int id);
}
