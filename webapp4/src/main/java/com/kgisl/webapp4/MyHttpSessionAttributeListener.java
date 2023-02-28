package com.kgisl.webapp4;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
        String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute added : " + attributeName + " : " + attributeValue);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
        String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute removed : " + attributeName + " : " + attributeValue);
        
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
        String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute replaced : " + attributeName + " : " + attributeValue);
        
    }
    
}
