package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.*;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.Mineral;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.SalesService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProviderConverter {
    private DozerBeanMapper dozerBeanMapper;
    private SalesService salesService;
    @Autowired
    public ProviderConverter(SalesService salesService){
        this.dozerBeanMapper = new DozerBeanMapper();
        this.salesService = salesService;
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
        category.setId(categoryEntity.getCategoryId().getId());
        category.setName(categoryEntity.getCategoryName());
        return category;
    }

    public Mineral mineralEntityToMineralModel(MineralEntity mineralEntity){
        Mineral mineral = new Mineral();
        mineral.setCategoryId(mineralEntity.getCategory().getId());
        dozerBeanMapper.map(mineralEntity, mineral);
        return mineral;
    }
    public MineralEntity mineralModelToMineralEntity(Mineral mineral){
        MineralEntity mineralEntity = new MineralEntity();
        mineralEntity.setCategory(new CategoryEntity(mineral.getCategoryId()));
        dozerBeanMapper.map(mineral, mineralEntity);
        return mineralEntity;
    }

    public OrderMineralEntity cartModelToOrderMineralEntity(Cart cart, User user){
        OrderMineralEntity orderMineralEntity = new OrderMineralEntity();
        orderMineralEntity.setPersonId(userModelToUserEntity(user));
        orderMineralEntity.setOrderDate(LocalDate.now());
        orderMineralEntity.setRealPrice(salesService.getTotalPrice(cart));
        orderMineralEntity.setPaid(false);
        return orderMineralEntity;
    }

    public OrderDetailEntity mineralModelToOrderDetailEntity(Mineral mineral, OrderMineralEntity orderMineralEntity, int quantity){
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        orderDetailEntity.setOrderMineralId(orderMineralEntity);
        orderDetailEntity.setMineralId(mineralModelToMineralEntity(mineral));
        orderDetailEntity.setQuantity(quantity);
        return orderDetailEntity;
    }
    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    public DozerBeanMapper getDozerBeanMapper() {
        return dozerBeanMapper;
    }
}
