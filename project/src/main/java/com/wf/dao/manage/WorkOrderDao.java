package com.wf.dao.manage;

import com.wf.entity.manage.WorkOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("workOrderDao")
public interface WorkOrderDao {
    public void insert(WorkOrder workOrder);
    public void delete(int id);
    public void update(WorkOrder workOrder);
    public List<WorkOrder> findWorkOrder(WorkOrder workOrder);
    public List<WorkOrder> findByDids(Integer dids[]);
    public WorkOrder findById(int id);
    public void deleteAll(String status);
}
