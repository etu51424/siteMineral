package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.configuration.Constants;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class WelcomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        return "integrated:welcome";
    }
}
