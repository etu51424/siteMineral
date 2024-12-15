package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.MineralDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.MineralDataAccess;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/article")
@SessionAttributes("cart")
public class ArticleController {
    private MineralDataAccess mineralDAO;

    @Autowired
    public ArticleController(MineralDAO mineralDAO){
        this.mineralDAO = mineralDAO;
    }
    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @GetMapping("/{mineralId}")
    public String getArticleById(Model model,
                                 @PathVariable("mineralId") int mineralId,
                                 @ModelAttribute("cart") Cart cart) {
        model.addAttribute("mineralId", mineralId);
        Mineral mineral = mineralDAO.getMineralById(mineralId);
        model.addAttribute("item", mineral);
        return "integrated:article";
    }

    // Méthode si aucun mineralId fournie
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> articlesWithNoId() {
        return ResponseEntity.ok("Vous devez choisir un identifiant de mineral ! \n Votre url devrait ressembler à : http://localhost:8082/mineral/article/mineralId");
    }

    @RequestMapping(value = "/{mineralId}/add", method = RequestMethod.POST)
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
        return "redirect:/article/" + itemId;  // Recharge la même page JSP
    }

    @RequestMapping(value = "/{mineralId}/sub", method = RequestMethod.POST)
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
        return "redirect:/article/" + itemId;  // Recharge la même page JSP
    }
}
