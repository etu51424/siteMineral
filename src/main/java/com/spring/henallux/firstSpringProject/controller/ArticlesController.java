package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.configuration.Constants;
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
@RequestMapping(value = "/articles")
@SessionAttributes("cart")
public class ArticlesController {
    private MineralDataAccess mineralDAO;

    @Autowired
    public ArticlesController(MineralDAO mineralDAO){
        this.mineralDAO = mineralDAO;
    }
    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @GetMapping("/{categoryId}")
    public String getArticleById(Model model,
                                 @PathVariable("categoryId") int categoryId,
                                 @ModelAttribute("cart") Cart cart) {
        model.addAttribute("categoryId", categoryId);
        ArrayList<Mineral> minerals = mineralDAO.getAllByCategoryId(categoryId);
        model.addAttribute("minerals", minerals);
        // cart.addMineral(minerals.get(0));
        return "integrated:articles";
    }
    // Méthode si aucune categoryId fournie
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> articlesWithNoId() {
        return ResponseEntity.ok("Vous devez choisir un identifiant de catégorie ! \n Votre url devrait ressembler à : http://localhost:8082/mineral/articles/categoryId");
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
        return "redirect:/articles/" + itemCategoryId;  // Recharge la même page JSP
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
        return "redirect:/articles/" + itemCategoryId;  // Recharge la même page JSP
    }
}
