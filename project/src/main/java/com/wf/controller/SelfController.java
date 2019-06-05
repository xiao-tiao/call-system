package com.wf.controller;

import com.wf.entity.system.Department;
import com.wf.entity.system.Function;
import com.wf.entity.system.Post;
import com.wf.entity.system.Staff;
import com.wf.global.FunctionTree;
import com.wf.service.SelfService;
import com.wf.service.system.DepartmentService;
import com.wf.service.system.PostService;
import com.wf.service.system.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller("selfController")
public class SelfController {
    @Autowired
    private SelfService selfService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private PostService postService;
    @Autowired
    private DepartmentService departmentService;


    public void toLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account=req.getParameter("account");
        String password=req.getParameter("password");
        Staff staff=selfService.login(account,password);
        if(staff==null)
        {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        else if(staff.getStatus().equals("正常"))
        {
            Map<Function,List<Function>> map=FunctionTree.functionTree(staff);
            List<Function> list=new ArrayList<Function>(map.keySet());
            Collections.sort(list, new Comparator<Function>() {
                public int compare(Function o1, Function o2) {
                    return o1.getSerialNum()-o2.getSerialNum();
                }
            });
            HttpSession session=req.getSession();
            session.setAttribute("TREE",map);
            session.setAttribute("SORT",list);
            session.setAttribute("staff",staff);
             resp.sendRedirect("main.do");
        }
        else
        {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        session.removeAttribute("staff");
        resp.sendRedirect("login.jsp");
    }

    public void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    public void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Staff staff= (Staff) session.getAttribute("staff");
        req.setAttribute("USER",staff);
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }


    public void toChangePassword(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Staff staff= (Staff) session.getAttribute("staff");
        req.setAttribute("USER",staff);
        req.getRequestDispatcher("change_password.jsp").forward(req,resp);
    }



    public void changePassword(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        Staff staff= (Staff) session.getAttribute("staff");
        String newPass=req.getParameter("password1");
        String pass=req.getParameter("password");
        if(pass.equals(staff.getPassword()))
        {
            selfService.changePass(staff.getId(),newPass);
            resp.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"logout.do\"</script>");
        }
       else
        {
           resp.sendRedirect("toChangePassword.do");
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
        Staff staff=new Staff();
        staff.setAccount(req.getParameter("account"));
        staff.setPassword(req.getParameter("password"));
        staff.setName(req.getParameter("name"));
        staff.setSex(req.getParameter("sex"));
        staff.setBornDate(new SimpleDateFormat("yy-mm-dd").parse(req.getParameter("bornDate")));
        staff.setIdNumber(req.getParameter("idNumber"));
        staffService.add(staff);
        String ids[] =req.getParameterValues("dep");
        if(ids==null)
        {

        }else
        {
            for(String id:ids)
            {
                Post post=new Post();
                post.setSid(staff.getId());
                post.setDid(Integer.parseInt(id));
                postService.add(post);
            }
        }
        resp.sendRedirect("toLogin.do");
    }




    public void toRegister(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        List<Department> department=departmentService.searchAll();
        req.setAttribute("DEP",department);
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

}
