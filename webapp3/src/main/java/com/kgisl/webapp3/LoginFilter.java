package com.kgisl.webapp3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        if(!(uname.equals("Hari") && pass.equals("123")))
        {
            
            pw.print("Error!!");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req, resp);
           
        }
        else
        {
            arg2.doFilter(req, resp);
        }
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }
    
}
