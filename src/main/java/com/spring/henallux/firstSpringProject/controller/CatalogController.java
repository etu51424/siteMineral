package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryTranslationDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryTranslationDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/catalog")
public class CatalogController {
    private CategoryTranslationDataAccess categoryTranslationDAO;
    @Autowired
    public CatalogController(CategoryTranslationDAO categoryTranslationDAO){
        this.categoryTranslationDAO = categoryTranslationDAO;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String catalog(Model model,
                          Locale locale){

        model.addAttribute("Categories", categoryTranslationDAO.getAllCategoryByLanguage(locale.toString()));
        return "integrated:catalog";
    }
}
