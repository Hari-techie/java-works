package com.kgisl.webapp4;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionActivationListener implements HttpSessionActivationListener{

    @Override
    public void sessionDidActivate(HttpSessionEvent event) {
        // TODO Auto-generated method stub
        System.out.println("Session will activate: " + event.getSession().getId());
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent event) {
        // TODO Auto-generated method stub
        System.out.println("Session did passivate: " + event.getSession().getId());
    }
    
}
