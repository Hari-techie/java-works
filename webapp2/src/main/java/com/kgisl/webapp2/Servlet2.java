package com.kgisl.webapp2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String dburl = context.getInitParameter("dburl");

        ServletConfig config = getServletConfig();
        String table = config.getInitParameter("table");

        req.setAttribute("dburl", dburl);
        req.setAttribute("table", table);

        RequestDispatcher rd = req.getRequestDispatcher("jsp1.jsp");
        rd.forward(req, resp);
    }
}
