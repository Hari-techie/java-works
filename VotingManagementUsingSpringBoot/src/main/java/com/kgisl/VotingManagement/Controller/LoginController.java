package com.kgisl.VotingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgisl.VotingManagement.Service.VoterService;

@Controller
public class LoginController {

    @Autowired
    private VoterService voterService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        if(email.equals("admin")&& password.equals("admin")){
            return "/result";
        }
        boolean authenticated = voterService.authenticate(email, password);
         if (authenticated) {
            // Authentication successful
            model.addAttribute("email", email);
            return "redirect:/polling";
        } else {
            // Authentication failed
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
