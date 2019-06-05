package com.wf.controller.manage;

import com.wf.entity.manage.Busines;
import com.wf.service.manage.BusinesService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller("businesController")
public class BusinesController {
    @Autowired
    private BusinesService businesService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Busines> list=businesService.findAll();
        request.setAttribute("BUSINES",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Busines busines=new Busines();
        String name= request.getParameter("name");
        String phone=request.getParameter("phone");
        String telPhone=request.getParameter("telphone");
        if(name==null||name.equals(""))
        {
            busines.setName(null);
        }
        else
        {
            busines.setName(request.getParameter("name"));
        }
        if(phone==null||phone.equals(""))
        {
            busines.setPhone(null);
        }
        else
        {
            busines.setPhone(request.getParameter("phone"));
        }
        if(telPhone==null||telPhone.equals(""))
        {
            busines.setTelPhone(null);
        }
        else
        {
            busines.setTelPhone(request.getParameter("telphone"));
        }
        Busines busines1=businesService.findOne(busines);
        request.setAttribute("BUSINES",busines1);
        request.getRequestDispatcher("query_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("add.jsp");
    }


    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Busines busines=new Busines();
        busines.setName(req.getParameter("name"));
        busines.setContact(req.getParameter("contact"));
        busines.setPhone(req.getParameter("phone"));
        busines.setTelPhone(req.getParameter("telphone"));
        busines.setLicence(req.getParameter("licence"));
        busines.setInfo(req.getParameter("info"));
        busines.setAddress(req.getParameter("address"));
        businesService.insert(busines);
        resp.sendRedirect("list.do");
    }

    public void toUpdate(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
            int id=Integer.parseInt(req.getParameter("id"));
            Busines busines=businesService.findById(id);
            req.setAttribute("BUSINES",busines);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
    }


    public void update(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Busines busines=new Busines();
        busines.setId(Integer.parseInt(req.getParameter("id")));
        busines.setName(req.getParameter("name"));
        busines.setPhone(req.getParameter("phone"));
        busines.setTelPhone(req.getParameter("telphone"));
        busines.setContact(req.getParameter("contact"));
        busines.setAddress(req.getParameter("address"));
        busines.setInfo(req.getParameter("info"));
        busines.setLicence(req.getParameter("licence"));
        businesService.update(busines);
        resp.sendRedirect("list.do");
    }


    public void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        businesService.delete(id);
        resp.sendRedirect("list.do");
    }

    public void getContent(HttpServletRequest req,HttpServletResponse resp)throws IOException
    {
        String keyWord=req.getParameter("keyWord");
        List<String> list=getContents(keyWord);
        JSONArray jsonArray=new JSONArray(list);
        resp.getWriter().write(jsonArray.toString());
    }

    public List<String> getContents(String keyWord)
    {
        List<String> list=new ArrayList<String>();
        list.add("0000");
        list.add("1111");
        return list;
    }
}
