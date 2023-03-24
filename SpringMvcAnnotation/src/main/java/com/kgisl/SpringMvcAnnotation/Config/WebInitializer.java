package com.kgisl.SpringMvcAnnotation.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    static
    {
        System.out.println("Web initializer");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        System.out.println("getRootConfigClasses");
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        System.out.println("getServletConfigClasses");
        return new Class[] { MVCconfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        System.out.println("getServletMappings");
        return new String[] { "/" };
    }
}
