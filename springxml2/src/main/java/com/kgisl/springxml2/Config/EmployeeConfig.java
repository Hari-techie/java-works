package com.kgisl.springxml2.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kgisl.springxml2.model.Employee;

@Configuration
public class EmployeeConfig { 
    static
    {
        System.out.println("Employee config");
    }
                              
    @Bean
    public Employee e() {
        return new Employee(40, "k");
    }

    @Autowired
    private Employee emp;

    @Bean 
    public Employee e1()
    {
        emp = new Employee();
        emp.setId(7);
        emp.setName("Ld");
        return emp;
    }
}
