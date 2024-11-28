package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
@RequestMapping(value="/update")
public class UpdateUserController {
    private UserDataAccess userDAO;
    @Autowired
    public UpdateUserController(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String updateUser(Model model){
        model.addAttribute("User", new User());
        model.addAttribute("todayDate", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return "integrated:updateUser";
    }
    @RequestMapping(value = "/send", method = RequestMethod.PATCH)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value="User") User user,
                              final BindingResult errors){
        if (!errors.hasErrors()){
            return "redirect:/home";
        }
        else{
            System.out.println(errors);
            return "integrated:updateUser";
        }
    }

}
