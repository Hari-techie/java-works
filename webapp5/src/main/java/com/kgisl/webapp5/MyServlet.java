package com.kgisl.webapp5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet1",
initParams = 
{
    @WebInitParam(name = "username", value = "hari"),
    @WebInitParam(name = "dept", value = "it")
}
)
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get method");
        String uname = getInitParameter("username");
        System.out.println(uname);
    }
}
