package com.kgisl.springxml1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/sm")
@Controller
public class ModelController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(Model model) {
        model.addAttribute("message", "Hello World!!");
        return "hello";
    }
    @RequestMapping("/helloworld")
    public String hello(ModelMap map) {
        String helloWorldMessage = "Hello world!";
        String welcomeMessage = "Welcome!";
        map.addAttribute("helloMessage", helloWorldMessage);
        map.addAttribute("welcomeMessage", welcomeMessage);
        return "hello";
    }
}
