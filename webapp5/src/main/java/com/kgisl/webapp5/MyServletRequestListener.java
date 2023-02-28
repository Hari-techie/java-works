package com.kgisl.webapp5;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener{

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Unimplemented method 'requestDestroyed'");
    }

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Unimplemented method 'requestInitialized'");
    }
    
}
