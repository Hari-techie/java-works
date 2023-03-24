package com.kgisl.springxml2.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgisl.springxml2.model.Employee;

@Controller
@RequestMapping("/main")
public class Test {  
    static
     {
        System.out.println("Test");
     }
     @RequestMapping(method = RequestMethod.GET)
    public static void main(String[] args) {  
          
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
          
        // Employee s = context.getBean("e", Employee.class);  
        // s.show();

        // Employee s1 = context.getBean("e1", Employee.class);
        // s1.show();

        // ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);

        // Employee e = context.getBean(Employee.class);
        // System.out.println("Employee ID: " + e.getId());
        // System.out.println("Employee Name: " + e.getName());

        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(Employee.class, () -> new Employee(50,"Leo"));
        context.refresh();
        Employee e = context.getBean(Employee.class);
        e.show();
    }  
}  