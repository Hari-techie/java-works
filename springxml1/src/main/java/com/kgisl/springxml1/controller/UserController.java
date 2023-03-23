package com.kgisl.springxml1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgisl.springxml1.model.User;
@Controller
@RequestMapping("/user")
public class UserController{
@RequestMapping("/showForm")
public String showForm(Model theModel) {
// create a User object
User user=new User();

// add user object to the model
theModel.addAttribute("user",user);
return "user-form";
}
@RequestMapping("/processForm")
public String processForm(@ModelAttribute("user") User user) {

return "user-detail";

}
}
