package com.kgisl.webapp4;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
    ServletContext ctx = null;
    static int current = 0, total = 0;
    @Override
    public void sessionCreated(HttpSessionEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getSession().getId());
        total++;
        current++;

        ctx=e.getSession().getServletContext();  
        ctx.setAttribute("totalusers", total);  
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("session destroyed "+arg0.getSession().getId());
        current--;
        ctx.setAttribute("currentusers", current);  
    }
    
}
