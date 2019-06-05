package com.wf.dao.manage;

import com.wf.entity.manage.Order;
import com.wf.entity.manage.WorkOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public interface OrderDao {
   public void addOrders(@Param("orders") List<Order> orders);
   public List<Order> findOrder(Order order);
   public Order findById(int  id);
}
