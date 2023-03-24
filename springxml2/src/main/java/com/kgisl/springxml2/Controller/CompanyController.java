package com.kgisl.springxml2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgisl.springxml2.model.Company;

@Controller

@RequestMapping("/c")
public class CompanyController {
    @RequestMapping("/cm")
    public void show()
    {
        Company c = new Company();
        
    }
}
