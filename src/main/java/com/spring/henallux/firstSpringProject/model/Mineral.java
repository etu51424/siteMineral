package com.spring.henallux.firstSpringProject.model;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Mineral {
    private int id;
    private String name;
    private int density;
    private double price;
    private int categoryId;
    private String imagePath;

    public Mineral(int id, String name, int density, double price, int categoryId, String imagePath){
        this.id = id;
        this.name = name;
        this.density = density;
        this.price = price;
        this.categoryId = categoryId;
        this.imagePath = imagePath;
    }
    public Mineral(int id){
        this.id = id;
    }

    public Mineral(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDensity() {
        return density;
    }

    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
