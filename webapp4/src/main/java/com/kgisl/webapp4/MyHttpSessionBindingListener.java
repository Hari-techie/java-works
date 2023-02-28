package com.kgisl.webapp4;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyHttpSessionBindingListener implements HttpSessionBindingListener
{
    String name;
    

    public MyHttpSessionBindingListener(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("value bound "+arg0.getName()+" is logged in");
        
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("value unbound "+arg0.getName()+" is logged out");
    }

}