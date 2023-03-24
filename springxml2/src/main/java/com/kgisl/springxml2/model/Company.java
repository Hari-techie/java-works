package com.kgisl.springxml2.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Company {
    
    @Autowired
    private Employee employee;
  
    

    public void show() {
        System.out.println("Company inst");
    }
}
