package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "category_translation")
public class CategoryTranslationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @JoinColumn(name="language_id", referencedColumnName = "id")
    @ManyToOne
    private LanguageEntity languageId;
    @JoinColumn(name="category_id", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity categoryId;
    @Column(name="category_name")
    private String categoryName;

    public int getId() {
        return id;
    }

    public LanguageEntity getLanguageId() {
        return languageId;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLanguageId(LanguageEntity languageId) {
        this.languageId = languageId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
