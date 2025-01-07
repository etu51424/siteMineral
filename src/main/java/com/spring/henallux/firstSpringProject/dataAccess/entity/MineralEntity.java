package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="mineral")
public class MineralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "density")
    private int density;
    @Column(name="price")
    private double price;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;
    @Column(name="image_path")
    private String imagePath;

    public MineralEntity( int id, String name, int density, double price, CategoryEntity category, String imagePath){
        this.id = id;
        this.category = category;
        this.name = name;
        this.density = density;
        this.price = price;
        this.imagePath = imagePath;
    }

    public MineralEntity(int id){
        this.id = id;
    }

    public MineralEntity(){

    }

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

    public CategoryEntity getCategory() {
        return category;
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

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
