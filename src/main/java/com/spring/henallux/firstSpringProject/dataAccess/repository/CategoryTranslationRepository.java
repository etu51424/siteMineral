package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CategoryTranslationRepository extends JpaRepository<CategoryTranslationEntity, Integer> {
    public Collection<CategoryTranslationEntity> findAllByLanguageId(LanguageEntity languageId);
}
