package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @OneToMany(mappedBy = "categoryId", fetch = FetchType.LAZY)
    private Collection<CategoryTranslationEntity> categoryTranslations;

    public int getId() {
        return id;
    }

    public Collection<CategoryTranslationEntity> getCategoryTranslations() {
        return categoryTranslations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryTranslations(Collection<CategoryTranslationEntity> categoryTranslations) {
        this.categoryTranslations = categoryTranslations;
    }
}
