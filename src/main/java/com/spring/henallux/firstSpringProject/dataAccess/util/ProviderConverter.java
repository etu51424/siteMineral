package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProviderConverter {
    private DozerBeanMapper dozerBeanMapper;

    public ProviderConverter(){
        this.dozerBeanMapper = new DozerBeanMapper();
    }

    public User userEntityToUserModel(UserEntity userEntity){
        User user = dozerBeanMapper.map(userEntity, User.class);
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAuthorities(userEntity.getAuthorities());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setEnabled(userEntity.getEnabled());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        return user;
    }
    public UserEntity userModelToUserEntity (User userModel){
        UserEntity user = new UserEntity();
        user.setBirthDate(userModel.getBirthDate());
        dozerBeanMapper.map(userModel, user);
        return user;
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        Collection<CategoryTranslationEntity> translations = categoryEntity.getCategoryTranslations();
        for (CategoryTranslationEntity categoryTranslationEntity : translations){
            category.getCategoryTranslations().put(categoryTranslationEntity.getLanguageId().getId(), categoryTranslationEntity.getCategoryName());
            category.setId(categoryEntity.getId());
        }
        return category;
    }

    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    public DozerBeanMapper getDozerBeanMapper() {
        return dozerBeanMapper;
    }
}
