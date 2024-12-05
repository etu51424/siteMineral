package com.spring.henallux.firstSpringProject.model;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class Category {
    private int id;
    private HashMap<Integer, String> categoryTranslations;
    public Category(){
        this.categoryTranslations = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public HashMap<Integer, String> getCategoryTranslations() {
        return categoryTranslations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryTranslations(HashMap<Integer, String> categoryTranslations) {
        this.categoryTranslations = categoryTranslations;
    }
    public String toString() {
        return id + "";
    }
}
