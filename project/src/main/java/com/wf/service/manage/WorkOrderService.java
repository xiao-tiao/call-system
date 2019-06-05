package com.wf.service.manage;

import com.wf.entity.manage.WorkOrder;

import java.util.List;

public interface WorkOrderService {
    public void add(WorkOrder workOrder);
    public void delete(int id);
    public void update(WorkOrder workOrder);
    public List<WorkOrder> queryOrder(WorkOrder workOrder);
    public List<WorkOrder> findByDids(List<Integer> dids);
    public WorkOrder findById(int id);
    public void deleteAll(String status);
}
