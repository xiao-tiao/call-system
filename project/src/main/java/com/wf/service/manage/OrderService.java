package com.wf.service.manage;

import com.wf.entity.manage.Order;

import java.util.List;

public interface OrderService {
   public void addOrders(List<Order> orders);
   public List<Order> findOrders(Order order);
   public Order findById(int id);
}
