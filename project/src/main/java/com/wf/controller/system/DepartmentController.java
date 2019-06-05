package com.wf.controller.system;

import com.wf.dao.system.FunctionDao;
import com.wf.dao.system.PostDao;
import com.wf.entity.system.Auth;
import com.wf.entity.system.Department;
import com.wf.entity.system.Function;
import com.wf.entity.system.Staff;
import com.wf.global.FunctionTree;
import com.wf.service.system.AuthService;
import com.wf.service.system.DepartmentService;
import com.wf.service.system.FunctionService;
import com.wf.service.system.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller("departmentController")
public class DepartmentController {

    @Autowired
    private FunctionService functionService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private AuthService authService;
    @Autowired
    private FunctionDao functionDao;
    @Autowired
    private PostDao postDao;
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> list=departmentService.searchAll();
        req.setAttribute("departmentList",list);
        req.getRequestDispatcher("department_list.jsp").forward(req,resp);
}
    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("department_add.jsp").forward(req,resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name= req.getParameter("name");
        String address= req.getParameter("address");
        Department department=new Department(name,address);
        departmentService.add(department);
        resp.sendRedirect("list.do");
    }


    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        departmentService.remove(id);
        resp.sendRedirect("list.do");
    }

    public void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        Department department=departmentService.searchOne(id);
        req.setAttribute("DEP",department);
        req.getRequestDispatcher("department_update.jsp").forward(req,resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        Department department=new Department(id,name,address);
        departmentService.update(department);
        resp.sendRedirect("list.do");
    }

    public void info(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        Department department=departmentService.searchOne(id);
        req.setAttribute("DEP",department);
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }


    public void deletePost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int id0=Integer.parseInt(req.getParameter("id0"));
        int id1=Integer.parseInt(req.getParameter("id1"));
        int[] id=new int[] {id0,id1};
        postDao.deleteBySDid(id);
        resp.sendRedirect("info.do?id="+id1+"");

    }

    public void lock(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        int id1=Integer.parseInt(req.getParameter("id1"));
        Staff staff=staffService.searchOne(id);
        staff.setStatus("锁定");
        staffService.updateStatus(staff);
        resp.sendRedirect("info.do?id="+id1+"");

    }

    public void unlock(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        int id1=Integer.parseInt(req.getParameter("id1"));
        Staff staff=staffService.searchOne(id);
        staff.setStatus("正常");
        staffService.updateStatus(staff);
        resp.sendRedirect("info.do?id="+id1+"");

    }

    public void function(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        Department department=departmentService.searchOne(id);
        req.setAttribute("DEP",department);
        for(Auth auth:department.getAuth())
        {
            System.out.println(auth.getFid());
            System.out.println(auth.getFunction().getName());

        }

        List<Function> root=functionService.findRoot();
        List<Function> other=functionService.findOther();
        Map<Function,List<Function>> map= FunctionTree.functionTree(root,other);
        req.setAttribute("TREE",map);
        req.getRequestDispatcher("function.jsp").forward(req,resp);
        department.getAuth().contains(root);

    }

    public void addAuth(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int did=Integer.parseInt(request.getParameter("dep"));
        authService.deleteByDid(did);
        String fids[]=request.getParameterValues("auth");
        Auth auth=new Auth();
        for(String fid:fids)
        {
            auth.setFid(Integer.parseInt(fid));
            auth.setDid(did);
            authService.add(auth);
        }
        response.sendRedirect("function.do?id="+did+"");


    }


}
