package com.kgisl.webapp7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/gson")
public class GsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("python");
        list.add("jsp");
        list.add("sql");

        String g1 = new Gson().toJson(list);
        resp.getWriter().print(g1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         System.out.println("insert method");
         //String requestData = new Gson().toJson(Json.stringify(req.getReader().lines().collect(Collectors.joining())));
         Gson g = new Gson();
        // Book neworder = g.fromJson(requestData, Book.class);
        // System.out.println(neworder.getId() + " " + neworder.getTitle() + " " + neworder.getAuthor() + " " + neworder.getPrice());
        }
}
