package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping (value="/inscription")
public class UserInscriptionController {
    private UserDataAccess userDAO;
    @Autowired
    public UserInscriptionController(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String UserIncriptionForm(Model model){
        model.addAttribute("User", new User());
        model.addAttribute("todayDate", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return "integrated:userInscription";
    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value = "User") User user,
                              final BindingResult errors){
        if (!errors.hasErrors()){
            userDAO.saveUser(user);
            return "redirect:/home";
        } else{
            System.out.println(errors);
            return "integrated:userInscription";
        }
    }
}
