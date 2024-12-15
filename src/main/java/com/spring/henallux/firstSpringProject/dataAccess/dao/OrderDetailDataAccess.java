package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderDetailEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import com.spring.henallux.firstSpringProject.model.Mineral;

public interface OrderDetailDataAccess {
    public OrderDetailEntity saveOrderDetail(Mineral mineral, OrderMineralEntity orderMineralEntity, int quantity);
}
