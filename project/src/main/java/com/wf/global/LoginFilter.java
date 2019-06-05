package com.wf.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)response;

        String path=req.getServletPath();
        if(path.toLowerCase().indexOf("login")!=-1||path.toLowerCase().indexOf("register")!=-1)
        {
            chain.doFilter(req,resp);
        }
        else
        {
            HttpSession session=req.getSession();
            if(session.getAttribute("staff")!=null)
            {
                chain.doFilter(req,resp);
            }
            else
            {
                resp.sendRedirect(req.getContextPath()+"/toLogin.do");
            }
        }
    }

    public void destroy() {

    }
}
