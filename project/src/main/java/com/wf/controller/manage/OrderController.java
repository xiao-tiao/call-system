package com.wf.controller.manage;

import com.wf.entity.manage.Order;
import com.wf.service.manage.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller("orderController")
public class OrderController {
    @Autowired
    private OrderService orderService;
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Order> orders=orderService.findOrders(new Order());
       req.setAttribute("ORDER",orders);
       req.getRequestDispatcher("list.jsp").forward(req,resp);

    }

    public void info(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
            int id=Integer.parseInt(req.getParameter("id"));
            Order order=orderService.findById(id);
            req.setAttribute("ORDER",order);
            req.getRequestDispatcher("info.jsp").forward(req,resp);

    }
}
