package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping (value="/inscription")
public class UserInscriptionController {
    @RequestMapping(method = RequestMethod.GET)
    public String UserIncriptionForm(Model model){
        model.addAttribute("User", new User());
        model.addAttribute("todayDate", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return "integrated:userInscription";
    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value = "User") User user){
        return "integrated:userInscription";
    }
}
