package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.configuration.Constants;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/home")
public class WelcomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        return "integrated:welcome";
    }
}
