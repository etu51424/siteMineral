package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes("cart")
public class CartController {
    @ModelAttribute("cart")
    public Cart initCart(){
        return new Cart();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String cart(@ModelAttribute("cart") Cart cart){
        return "integrated:cart";
    }
}
