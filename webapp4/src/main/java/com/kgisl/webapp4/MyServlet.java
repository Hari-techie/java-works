package com.kgisl.webapp4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        System.out.println(uname);

        HttpSession session = req.getSession();
        session.setAttribute("uname", uname);

        resp.setContentType("text/html");  
        PrintWriter out = resp.getWriter(); 
        out.print("<a href = \"/logout\">Logout</a>");

        ServletContext ctx=getServletContext();  
        System.out.println("total : "+ctx.getAttribute("totalusers"));

        session.setAttribute("username", new MyHttpSessionBindingListener(uname));

       // MyHttpSessionActivationListener listener = new MyHttpSessionActivationListener();
        session.setAttribute("myhttpsessionactionlistener", new MyHttpSessionActivationListener()); 
        
    }
}
