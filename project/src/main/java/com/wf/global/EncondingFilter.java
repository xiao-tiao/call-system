package com.wf.global;


import javax.servlet.*;
import java.io.IOException;

public class EncondingFilter implements Filter {
    private String enconding="utf-8";
    public void init(FilterConfig filterConfig) throws ServletException {
       if(filterConfig.getInitParameter("ENCONDING")!=null)
        enconding=filterConfig.getInitParameter("ENCONDING");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(enconding);
        response.setCharacterEncoding(enconding);
        chain.doFilter(request,response);

    }

    public void destroy() {
            enconding=null;
    }
}
