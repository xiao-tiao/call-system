package com.wf.service.manage.impl;

import com.wf.dao.manage.WorkOrderDao;
import com.wf.dao.system.DepartmentDao;
import com.wf.entity.manage.WorkOrder;
import com.wf.entity.system.Department;
import com.wf.service.manage.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("workOrderService")
public class WorkOrderServiceImpl implements WorkOrderService {
    @Autowired
    private WorkOrderDao workOrderDao;
    @Autowired
    private DepartmentDao departmentDao;
    public void add(WorkOrder workOrder) {
        workOrder.setCreateTime(new Date());
        Department department=departmentDao.findOne(workOrder.getDid());
        Random random=new Random();
        int index=random.nextInt(department.getPost().size());
        int sid = department.getPost().get(index).getStaff().getId();
        workOrder.setSid(sid);
        workOrder.setStatus("待办");
        workOrderDao.insert(workOrder);
    }

    public void delete(int id) {
            workOrderDao.delete(id);
    }

    public void update(WorkOrder workOrder) {
        workOrder.setStatus("已办");
        workOrder.setHandTime(new Date());
        workOrderDao.update(workOrder);
    }

    public List<WorkOrder> queryOrder(WorkOrder workOrder) {
        return workOrderDao.findWorkOrder(workOrder);
    }

    public List<WorkOrder> findByDids(List<Integer> dids) {
        Integer did[]=(Integer[]) dids.toArray(new Integer [] {} );
        return workOrderDao.findByDids(did);
    }

    public WorkOrder findById(int id) {
        return workOrderDao.findById(id);
    }

    public void deleteAll(String status) {
        workOrderDao.deleteAll(status);
    }
}
