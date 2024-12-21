package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDetailDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDetailDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderMineralDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderMineralDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class PaymentService {
    private OrderDetailDataAccess orderDetailDAO;
    private OrderMineralDataAccess orderMineralDAO;
    @Autowired
    public PaymentService(OrderMineralDAO orderMineralDAO, OrderDetailDAO orderDetailDAO){
        this.orderDetailDAO = orderDetailDAO;
        this.orderMineralDAO = orderMineralDAO;
    }

    public OrderMineralEntity proceedToPayment(Cart cart, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        OrderMineralEntity orderMineralEntity = orderMineralDAO.saveOrderMineral(cart,user);
        for (Mineral mineral : cart.getContent().keySet()){
            orderDetailDAO.saveOrderDetail(mineral, orderMineralEntity, cart.getContent().get(mineral));
        }
        return orderMineralEntity;
    }

    public void transactionDone(Cart cart, OrderMineralEntity orderMineralEntity){
        cart.getContent().clear();
        orderMineralEntity.setPaid(true);
        orderMineralDAO.saveOrderMineral(orderMineralEntity);
    }
}
