package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
        model.addAttribute("User" , new User());
        model.addAttribute("todayDate", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return "integrated:updateUser";
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              @ModelAttribute(value="User") User user,
                              Authentication authentication,
                              final BindingResult errors){
        if (!errors.hasErrors()){
            User userDetails = (User) authentication.getPrincipal();
            User updatedUser = getUpdatedUser(user, userDetails);
            userDAO.updateUser(updatedUser);
            return "redirect:/home";
        }
        else{
            System.out.println(errors);
            return "integrated:updateUser";
        }
    }

    public User getUpdatedUser(User user, User userDetails){
        if (!user.getFirstName().isEmpty()){
            userDetails.setFirstName(user.getFirstName());
        }
        if (!user.getLastName().isEmpty()){
            userDetails.setLastName(user.getLastName());
        }
        if(!user.getAddress().isEmpty()){
            userDetails.setAddress(user.getAddress());
        }
        if(!user.getEmail().isEmpty()){
            userDetails.setEmail(user.getEmail());
        }
        if(!user.getPhoneNumber().isEmpty()){
            userDetails.setPhoneNumber(user.getPhoneNumber());
        }
        if(!(user.getGender() == userDetails.getGender())){
            userDetails.setGender(user.getGender());
        }
        if(!(user.getBirthDate() == null)){
            userDetails.setBirthDate(user.getBirthDate());
        }
        if(!user.getPassword().isEmpty()){
            userDetails.setPassword(user.getPassword());
        }
        return userDetails;
    }

}
