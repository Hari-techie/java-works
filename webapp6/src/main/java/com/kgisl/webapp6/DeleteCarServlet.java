package com.kgisl.webapp6;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeleteCarServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //List<Car> carList = (List<Car>) req.getAttribute("carList");
       // String queryString = req.getQueryString();

       HttpSession session = req.getSession();
       List<Car> carList = (List<Car>) session.getAttribute("carList");
       int id = Integer.parseInt(req.getParameter("id"));

    //    for (Car car : carList) {
    //     if(car.getId()==id)
    //     {
    //         carList.remove(car);
    //     }
    //    }

        Iterator<Car> itr = carList.iterator();
        while(itr.hasNext())
        {
            Car c = itr.next();
            if(c.getId()==id)
            {
                itr.remove();
            }
        }

       resp.sendRedirect("index.jsp");
       //System.out.println(carList);
    }
}
