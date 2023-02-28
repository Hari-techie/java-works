package com.kgisl.webapp4;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        // TODO Auto-generated method stub
        System.out.println("The  request object destroyed at :" + new java.util.Date());
        System.out.println("The source of destroyed request is :" + event.getSource());
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        // TODO Auto-generated method stub
        System.out.println("new request object is created at :" + new java.util.Date());
        System.out.println("The source of  creation request is :" + event.getSource());
        System.out.println("The context is :" + event.getServletContext());
        System.out.println("The  request is :" + event.getServletRequest());

    }

}
