package com.spring.henallux.firstSpringProject.model;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class Category {
    private int id;
    private String name;

    public Category(){
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return id + "";
    }
}
