package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryTranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.MineralEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.Mineral;
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

    public Category categoryTranslationEntityToCategoryModel(CategoryTranslationEntity categoryEntity){
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getCategoryName());
        return category;
    }

    public Mineral mineralEntityToMineralModel(MineralEntity mineralEntity){
        Mineral mineral = new Mineral();
        mineral.setCategoryId(mineralEntity.getCategory().getId());
        dozerBeanMapper.map(mineralEntity, mineral);
        return mineral;
    }

    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    public DozerBeanMapper getDozerBeanMapper() {
        return dozerBeanMapper;
    }
}
