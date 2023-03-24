package com.kgisl.SpringMvcAnnotation.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.kgisl.SpringMvcAnnotation")
public class MVCconfig implements WebMvcConfigurer {
    static
    {
        System.out.println("MVC config");
    }

}
