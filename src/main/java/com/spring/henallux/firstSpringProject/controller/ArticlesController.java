package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.MineralDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.MineralDataAccess;
import com.spring.henallux.firstSpringProject.model.Mineral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/articles")
public class ArticlesController {
    private MineralDataAccess mineralDAO;
    @Autowired
    public ArticlesController(MineralDAO mineralDAO){
        this.mineralDAO = mineralDAO;
    }

    @GetMapping("/{categoryId}")
    public String getArticleById(Model model,
                                 @PathVariable("categoryId") int categoryId) {
        model.addAttribute("categoryId", categoryId);
        ArrayList<Mineral> minerals = mineralDAO.getAllByCategoryId(categoryId);
        return "integrated:articles";
    }
    // Méthode si aucune categoryId fournie
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> articlesWithNoId() {
        return ResponseEntity.ok("Vous devez choisir un identifiant de catégorie ! \n Votre url devrait ressembler à : http://localhost:8082/mineral/articles/categoryId");
    }
}
