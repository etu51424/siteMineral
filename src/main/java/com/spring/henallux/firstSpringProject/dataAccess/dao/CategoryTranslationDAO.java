package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CategoryTranslationDAO implements CategoryTranslationDataAccess{
    private ProviderConverter providerConverter;
    private CategoryTranslationRepository categoryTranslationRepository;

    @Autowired
    public CategoryTranslationDAO(ProviderConverter providerConverter, CategoryTranslationRepository categoryTranslationRepository){
        this.categoryTranslationRepository = categoryTranslationRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Category> getAllCategoryByLanguage(String locale){
        int languageId;
        switch(locale){
            case "fr":
                languageId = 1;
                break;
            case "en":
                languageId = 2;
                break;
            default:
                languageId = 1;
        }
        System.out.println(languageId);
        Collection<CategoryTranslationEntity> categoryTranslationEntities = categoryTranslationRepository.findAllByLanguageId(new LanguageEntity(languageId));

        ArrayList<Category> categories = new ArrayList<>();
        for (CategoryTranslationEntity categoryEntity : categoryTranslationEntities){
            categories.add(providerConverter.categoryTranslationEntityToCategoryModel(categoryEntity));
        }
        return categories;
    }
}
