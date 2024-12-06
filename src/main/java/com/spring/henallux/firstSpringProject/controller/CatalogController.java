package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/catalog")
public class CatalogController {
    private CategoryDataAccess categoryDAO;
    @Autowired
    public CatalogController(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String catalog(Model model){
        model.addAttribute("Categories", categoryDAO.getAllCategories());
        return "integrated:catalog";
    }
}
