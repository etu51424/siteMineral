package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderMineralRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderMineralDAO implements OrderMineralDataAccess{
    private OrderMineralRepository orderMineralRepository;
    private ProviderConverter providerConverter;
    @Autowired
    public OrderMineralDAO(OrderMineralRepository orderMineralRepository, ProviderConverter providerConverter){
        this.orderMineralRepository = orderMineralRepository;
        this.providerConverter = providerConverter;
    }

    public OrderMineralEntity saveOrderMineral(Cart cart, User user){
        OrderMineralEntity orderMineralEntity = providerConverter.cartModelToOrderMineralEntity(cart, user);
        orderMineralRepository.save(orderMineralEntity);
        return orderMineralEntity;
    }
    public OrderMineralEntity saveOrderMineral(OrderMineralEntity orderMineralEntity){
        orderMineralRepository.save(orderMineralEntity);
        return orderMineralEntity;
    }
}
