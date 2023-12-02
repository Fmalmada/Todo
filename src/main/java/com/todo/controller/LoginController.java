package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/tareas/login")
    public String login(Model modelo) {
        modelo.addAttribute("error", false);
        return "login";
    }

    @RequestMapping("/tareas/loginError")
    public String loginError(Model modelo) {
        modelo.addAttribute("error", true);
        return "login";
    }
    
}
