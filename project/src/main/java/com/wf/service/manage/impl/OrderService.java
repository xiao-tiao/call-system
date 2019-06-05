package com.wf.service.manage.impl;

import com.wf.dao.manage.OrderDao;
import com.wf.entity.manage.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService") class OrderService implements com.wf.service.manage.OrderService {

    @Autowired
    private OrderDao orderDao;
    public void addOrders(List<Order> orders) {
        for(Order order:orders)
        {

            long l=order.getHandTime().getTime()-order.getCreateTime().getTime();
            long day=l/(24*60*60*1000);
            long hour=(l/(60*60*1000));
            int timeOut=(int)hour-order.getTime();
            if(timeOut>0)
            {
                order.setTimeOut(timeOut);
            }
            else
            {
                order.setTimeOut(0);
            }

        }
        orderDao.addOrders(orders);
    }

    public List<Order> findOrders(Order order) {
        return orderDao.findOrder(order);
    }

    public Order findById(int id) {
        return orderDao.findById(id);
    }
}
