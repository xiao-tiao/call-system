package com.wf.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.entity.Log;
import com.wf.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {
    @Autowired
    private LogService logService;

    public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num=request.getParameter("num");
        Page<?> page= PageHelper.startPage(Integer.parseInt(num),10);
        List<Log> list = logService.getOperationLog();
        PageInfo<?> pageInfo=page.toPageInfo();
        request.setAttribute("LIST",list);
        request.setAttribute("type","operation");
        request.setAttribute("TYPE","操作");
        request.setAttribute("pagehelper",pageInfo);
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }

    public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num=request.getParameter("num");
        Page<?> page= PageHelper.startPage(Integer.parseInt(num),10);
        List<Log> list = logService.getLoginLog();
        PageInfo<?> pageInfo=page.toPageInfo();
        request.setAttribute("LIST",list);
        request.setAttribute("type","login");
        request.setAttribute("TYPE","登陆");
        request.setAttribute("pagehelper",pageInfo);
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }

    public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num=request.getParameter("num");
        Page<?> page= PageHelper.startPage(Integer.parseInt(num),10);
        List<Log> list = logService.getSystemLog();
        PageInfo<?> pageInfo=page.toPageInfo();
        request.setAttribute("LIST",list);
        request.setAttribute("type","system");
        request.setAttribute("TYPE","系统");
        request.setAttribute("pagehelper",pageInfo);
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }
}
