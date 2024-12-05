package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="language")
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="label")
    private String label;
    @OneToMany(mappedBy = "languageId")
    private Collection<CategoryTranslationEntity> categoryTranslations;

    public int getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }

    public Collection<CategoryTranslationEntity> getCategoryTranslations() {
        return categoryTranslations;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public void setCategoryTranslations(Collection<CategoryTranslationEntity> categoryTranslations) {
        this.categoryTranslations = categoryTranslations;
    }
}
