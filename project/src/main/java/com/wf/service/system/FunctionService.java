package com.wf.service.system;


import com.wf.entity.system.Function;

import java.util.List;

public interface FunctionService {
    public void add(Function function);
    public void delete(int id);
    public void update(Function function);
    public Function searchOne(int id);
    public List<Function> searchAll();
    public List<Function> findRoot();
    public List<Function> findOther();
    public List<Function> findByParentId(int id);

}
