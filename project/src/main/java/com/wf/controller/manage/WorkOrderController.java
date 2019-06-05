package com.wf.controller.manage;

import com.wf.entity.manage.Busines;
import com.wf.entity.manage.Order;
import com.wf.entity.system.Department;
import com.wf.entity.manage.WorkOrder;
import com.wf.entity.system.Post;
import com.wf.entity.system.Staff;
import com.wf.service.manage.BusinesService;
import com.wf.service.manage.OrderService;
import com.wf.service.system.DepartmentService;
import com.wf.service.manage.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller("workOrderController")
public class WorkOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private BusinesService businesService;
    @Autowired
    private DepartmentService departmentService;
    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid=Integer.parseInt(req.getParameter("id"));
        Busines busines=businesService.findById(bid);
        List<Department> department=departmentService.searchAll();
        req.setAttribute("DEPARTMENT",department);
        req.setAttribute("BUSINES",busines);
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }

    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        WorkOrder workOrder=new WorkOrder();
        workOrder.setBid(Integer.parseInt(req.getParameter("busines")));
        workOrder.setClas(req.getParameter("class"));
        workOrder.setDid(Integer.parseInt(req.getParameter("department")));
        workOrder.setInfo(req.getParameter("info"));
        workOrder.setMode(req.getParameter("mode"));
        workOrder.setQuestion(req.getParameter("question"));
        workOrder.setTime(Integer.parseInt(req.getParameter("time")));
        workOrderService.add(workOrder);
        resp.sendRedirect("../busines/list.do");
    }

    public void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        List<WorkOrder> list=workOrderService.queryOrder(new WorkOrder());
        List<WorkOrder> backLog=new ArrayList<WorkOrder>();
        List<WorkOrder> haveDone=new ArrayList<WorkOrder>();
        for(WorkOrder workOrder:list)
        {
            if(workOrder.getStatus().equals("待办"))
            {

                backLog.add(workOrder);
            }
            else if (workOrder.getStatus().equals("已办"))
            {
                haveDone.add(workOrder);
            }
        }
        if(type.equals("待办"))
        {
            req.setAttribute("type","other");
            req.setAttribute("WORKORDER",backLog);

        }
        else if(type.equals("已办"))
        {
            req.setAttribute("out","all");
            req.setAttribute("WORKORDER",haveDone);
        }
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }

    public void listDep(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Staff staff=(Staff)session.getAttribute("staff");
        List<Integer> dids=new ArrayList<Integer>();
        for(Post post:staff.getPost())
        {
            dids.add(post.getDepartment().getId());
        }
        List<WorkOrder> dep=workOrderService.findByDids(dids);
        String type=req.getParameter("type");
        List<WorkOrder> backLog=new ArrayList<WorkOrder>();
        List<WorkOrder> haveDone=new ArrayList<WorkOrder>();
        for(WorkOrder workOrder:dep)
        {
            if(workOrder.getStatus().equals("待办"))
            {
                backLog.add(workOrder);
            }
            else  if (workOrder.getStatus().equals("已办"))
            {
                haveDone.add(workOrder);
            }
        }
        if(type.equals("待办"))
        {
            req.setAttribute("type","other");
            req.setAttribute("WORKORDER",backLog);

        }
        else if(type.equals("已办"))
        {
            req.setAttribute("WORKORDER",haveDone);
        }
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }

    public void listSelf(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        WorkOrder order=new WorkOrder();
        Staff staff=(Staff)session.getAttribute("staff");
        order.setSid(staff.getId());
        List<WorkOrder> self=workOrderService.queryOrder(order);
        String type=req.getParameter("type");
        List<WorkOrder> backLog=new ArrayList<WorkOrder>();
        List<WorkOrder> haveDone=new ArrayList<WorkOrder>();
        for(WorkOrder workOrder:self)
        {
            if(workOrder.getStatus().equals("待办"))
            {
                backLog.add(workOrder);
            }
            else  if (workOrder.getStatus().equals("已办"))
            {
                req.setAttribute("type","staff");
                haveDone.add(workOrder);
            }
        }
        if(type.equals("待办"))
        {
            req.setAttribute("type","staff");
            req.setAttribute("WORKORDER",backLog);

        }
        else if(type.equals("已办"))
        {
            req.setAttribute("WORKORDER",haveDone);
        }
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }


    public void  toTransact(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {

        WorkOrder workOrder=workOrderService.findById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("ORDER",workOrder);
        req.getRequestDispatcher("transact.jsp").forward(req,resp);
    }

    public void transact(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        WorkOrder workOrder=new WorkOrder();
        workOrder.setId(Integer.parseInt(req.getParameter("id")));
        workOrder.setResolve(req.getParameter("resolve"));
        workOrderService.update(workOrder);
        req.getRequestDispatcher("listSelf.do?type=待办").forward(req,resp);
    }

    public void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        int id=Integer.parseInt(req.getParameter("id"));
        workOrderService.delete(id);
        String status=req.getParameter("type");
        if(status.equals("待办"))
        {
            req.getRequestDispatcher("listSelf.do?type=待办").forward(req,resp);
        }
        if(status.equals("已办"))
        {
            req.getRequestDispatcher("listSelf.do?type=已办").forward(req,resp);
        }


    }

    public void info(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        WorkOrder workOrder=workOrderService.findById(id);
        req.setAttribute("ORDER",workOrder);
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }


    public void out(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        WorkOrder workOrder=new WorkOrder();
        workOrder.setStatus("已办");
        List<WorkOrder> workOrders=workOrderService.queryOrder(workOrder);
        workOrderService.deleteAll("已办");
        List<Order> orders=new ArrayList<Order>();
        for(WorkOrder workOrder1:workOrders)
        {
            Order order=new Order();
            order.setTime(workOrder1.getTime());
            order.setBid(workOrder1.getBid());
            order.setClas(workOrder1.getClas());
            order.setCreateTime(workOrder1.getCreateTime());
            order.setDid(workOrder1.getDid());
            order.setHandTime(workOrder1.getHandTime());
            order.setInfo(workOrder1.getInfo());
            order.setQuestion(workOrder1.getQuestion());
            order.setSid(workOrder1.getSid());
            order.setStatus(workOrder1.getStatus());
            order.setMode(workOrder1.getMode());
            order.setResolve(workOrder1.getResolve());
            orders.add(order);
        }
        orderService.addOrders(orders);
        resp.sendRedirect("list.do?type=已办");
    }



}
