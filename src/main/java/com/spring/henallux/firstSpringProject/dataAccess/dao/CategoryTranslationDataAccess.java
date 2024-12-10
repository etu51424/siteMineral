package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Category;

import java.util.ArrayList;

public interface CategoryTranslationDataAccess {
    public ArrayList<Category> getAllCategoryByLanguage(String locale);
}
