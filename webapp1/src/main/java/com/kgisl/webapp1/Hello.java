package com.kgisl.webapp1;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet doGet() calling");
        String uname = req.getParameter("uname");
        System.out.println(uname);
        String pass = req.getParameter("pass");
        System.out.println(pass);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet doPost() calling");
        String uname = req.getParameter("uname");
        System.out.println(uname);
        String pass = req.getParameter("pass");
        System.out.println(pass);

        req.setAttribute("uname", uname);
        req.setAttribute("pass", pass);

        // RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
        // rd.forward(req, resp);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.include(req, resp);
    } 
}