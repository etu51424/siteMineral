package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDetailDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDetailDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderMineralDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderMineralDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.PaymentService;
import com.spring.henallux.firstSpringProject.service.SalesService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes("cart")
public class CartController {
    private PaymentService paymentService;
    private SalesService salesService;
    @Autowired
    public CartController(PaymentService paymentService, SalesService salesService){
        this.paymentService = paymentService;
        this.salesService = salesService;
    }
    @ModelAttribute("cart")
    public Cart initCart(){
        return new Cart();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String cart(@ModelAttribute("cart") Cart cart,
                       Model model){
        model.addAttribute("totalPrice", salesService.getTotalPrice(cart));
        return "integrated:cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMineral(
            @ModelAttribute("itemId") int itemId,
            @ModelAttribute("itemName") String itemName,
            @ModelAttribute("itemDensity") int itemDensity,
            @ModelAttribute("itemPrice") double itemPrice,
            @ModelAttribute("itemCategoryId") int itemCategoryId,
            @ModelAttribute("itemImagePath") String itemImagePath,
            @ModelAttribute("cart") Cart cart)
    {
        Mineral item = new Mineral(itemId,itemName,itemDensity,itemPrice,itemCategoryId,itemImagePath);
        cart.addMineral(item);
        return "redirect:/cart";  // Recharge la même page JSP
    }

    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public String subMineral(
            @ModelAttribute("itemId") int itemId,
            @ModelAttribute("itemName") String itemName,
            @ModelAttribute("itemDensity") int itemDensity,
            @ModelAttribute("itemPrice") double itemPrice,
            @ModelAttribute("itemCategoryId") int itemCategoryId,
            @ModelAttribute("itemImagePath") String itemImagePath,
            @ModelAttribute("cart") Cart cart)
    {
        Mineral item = new Mineral(itemId,itemName,itemDensity,itemPrice,itemCategoryId,itemImagePath);
        cart.subMineral(item);
        return "redirect:/cart";  // Recharge la même page JSP
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeMineral(
            @ModelAttribute("itemId") int itemId,
            @ModelAttribute("itemName") String itemName,
            @ModelAttribute("itemDensity") int itemDensity,
            @ModelAttribute("itemPrice") double itemPrice,
            @ModelAttribute("itemCategoryId") int itemCategoryId,
            @ModelAttribute("itemImagePath") String itemImagePath,
            @ModelAttribute("cart") Cart cart)
    {
        Mineral item = new Mineral(itemId,itemName,itemDensity,itemPrice,itemCategoryId,itemImagePath);
        cart.removeMineral(item);
        return "redirect:/cart";  // Recharge la même page JSP
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String payCart(@ModelAttribute("cart") Cart cart)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Vérification si un utilisateur est authentifié
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")){
            return "redirect:/login";
        }
        else{
            if (cart.getContent().size() > 0) {
                paymentService.proceedToPayment(cart, authentication);
                return "redirect:/cart";
            }
            else{
                return "redirect:/home";
            }
        }

    }
}
