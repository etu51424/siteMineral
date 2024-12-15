package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface OrderMineralDataAccess {
    public OrderMineralEntity saveOrderMineral(Cart cart, User user);
    public OrderMineralEntity saveOrderMineral(OrderMineralEntity orderMineralEntity);
}
