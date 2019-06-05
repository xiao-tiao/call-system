package com.wf.controller.system;

import com.wf.entity.system.Function;
import com.wf.global.FunctionTree;
import com.wf.service.system.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller("functionController")
public class FunctionController {
    @Autowired
    private FunctionService functionService;
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Function> root=functionService.findRoot();
        req.setAttribute("ROOT",root);
        req.setAttribute("NAME","主");
       req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        List<Function> other=functionService.findByParentId(id);

        String name=functionService.searchOne(id).getName();
        req.setAttribute("NAME",name);
        req.setAttribute("ROOT",other);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    public void toAdd(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        int id=Integer.parseInt(req.getParameter("id"));
        int accordion=Integer.parseInt(req.getParameter("accordion"));
        req.setAttribute("id",id);
        req.setAttribute("accordion",accordion);
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }

    public void toAddRoot(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {

       resp.sendRedirect("add.jsp");
    }

    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
            Function function=new Function();
            function.setName(req.getParameter("name"));
            function.setParentId(Integer.parseInt(req.getParameter("parentId")));
            function.setAccordion(Integer.parseInt(req.getParameter("accordion")));
            function.setSerialNum(Integer.parseInt(req.getParameter("serialNum")));
            function.setInfo(req.getParameter("info"));
            function.setUrl(req.getParameter("url"));
            functionService.add(function);
            if(function.getAccordion()==0)
            {
                resp.sendRedirect("list.do");
            }
            else
            {
                resp.sendRedirect("query.do?id="+function.getParentId()+"");
            }

    }

    public void toUpdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        Function function=functionService.searchOne(id);
        req.setAttribute("FUNCTION",function);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }


    public void update(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Function function=new Function();
        function.setId(Integer.parseInt(req.getParameter("id")));
        function.setName(req.getParameter("name"));
        function.setParentId(Integer.parseInt(req.getParameter("parentId")));
        function.setAccordion(Integer.parseInt(req.getParameter("accordion")));
        function.setSerialNum(Integer.parseInt(req.getParameter("serialNum")));
        function.setInfo(req.getParameter("info"));
        function.setUrl(req.getParameter("url"));
        functionService.update(function);
        if(function.getAccordion()==0)
        {
            resp.sendRedirect("list.do");
        }
        else
        {
            resp.sendRedirect("query.do?id="+function.getParentId()+"");
        }

    }


    public void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        int id=Integer.parseInt(req.getParameter("id"));
        Function function=functionService.searchOne(id);
        functionService.delete(id);
        if(function.getAccordion()==0)
        {
            resp.sendRedirect("list.do");
        }
        else
        {
            resp.sendRedirect("query.do?id="+function.getParentId()+"");
        }

    }
}
