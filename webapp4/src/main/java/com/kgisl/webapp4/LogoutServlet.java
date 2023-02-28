package com.kgisl.webapp4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // req.getSession(false);
        HttpSession session = req.getSession(false);    
        session.invalidate();
        
        System.out.println("current : "+MyListener.current);
        // //System.out.println(MyListener.current);
        // RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        // rd.forward(req, resp);
    }
}
