package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderDetailEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderDetailRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderMineralRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderDetailDAO implements OrderDetailDataAccess{
    private ProviderConverter providerConverter;
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    public OrderDetailDAO(ProviderConverter providerConverter, OrderDetailRepository orderDetailRepository){
        this.orderDetailRepository = orderDetailRepository;
        this.providerConverter = providerConverter;
    }

    public OrderDetailEntity saveOrderDetail(Mineral mineral, OrderMineralEntity orderMineralEntity, int quantity){
        OrderDetailEntity orderDetailEntity = providerConverter.mineralModelToOrderDetailEntity(mineral, orderMineralEntity, quantity);
        orderDetailRepository.save(orderDetailEntity);
        return orderDetailEntity;
    }
}
