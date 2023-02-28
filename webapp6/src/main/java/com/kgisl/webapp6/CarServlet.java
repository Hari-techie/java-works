package com.kgisl.webapp6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/carservlet", "/delete", "/edit", "/update" })
public class CarServlet extends HttpServlet {
    ArrayList<Car> carList = new ArrayList<Car>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // carList.add(new Car(1, "BMW", 1500));
        // carList.add(new Car(2, "Audi", 3000));
        // carList.add(new Car(3, "Nano", 4000));
        // carList.add(new Car(4, "Maruthi", 4500));

        String userPath = req.getServletPath();
        if (userPath.equals("/delete")) {
            int id = Integer.valueOf(req.getParameter("id"));
            Iterator<Car> itr = carList.iterator();
            while (itr.hasNext()) {
                Car c = itr.next();
                if (c.getId() == id) {
                    itr.remove();
                    break;
                }
            }
            // RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            // req.setAttribute("carList", carList);
            // rd.forward(req, resp);
        }

        if (userPath.equals("/edit")) {
            int id = Integer.valueOf(req.getParameter("id"));
            String name = "";
            float price = 0;
            Iterator<Car> itr = carList.iterator();
            while (itr.hasNext()) {
                Car c = itr.next();
                if (c.getId() == id) {
                    name = c.getName();
                    price = c.getPrice();
                    break;
                }
            }

            req.setAttribute("id", id);
            req.setAttribute("name", name);
            req.setAttribute("price", price);

            // RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
            // rd.forward(req, resp);
        }

        if (userPath.equals("/update")) {
            int id = Integer.valueOf(req.getParameter("id"));
            String name = req.getParameter("name");
            float price = Float.parseFloat(req.getParameter("price"));
            Iterator<Car> itr = carList.iterator();
            while (itr.hasNext()) {
                Car c = itr.next();
                if (c.getId() == id) {
                    c.setName(name);
                    c.setPrice(price);
                    break;
                }
            }
            // RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            // req.setAttribute("carList", carList);
            // rd.forward(req, resp);
        }
        // resp.sendRedirect("index.jsp");
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        req.setAttribute("carList", carList);
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        carList.add(new Car(id, name, price));

        // HttpSession session = req.getSession();
        // session.setAttribute("carList", carList);

        // System.out.println(carList);
        // req.setAttribute("carList", carList);
        doGet(req, resp);
    }

}
