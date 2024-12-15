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
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class PaymentService {
    private OrderDetailDataAccess orderDetailDAO;
    private OrderMineralDataAccess orderMineralDAO;
    @Autowired
    public PaymentService(OrderMineralDAO orderMineralDAO, OrderDetailDAO orderDetailDAO){
        this.orderDetailDAO = orderDetailDAO;
        this.orderMineralDAO = orderMineralDAO;
    }

    public boolean proceedToPayment(Cart cart, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        OrderMineralEntity orderMineralEntity = orderMineralDAO.saveOrderMineral(cart,user);
        for (Mineral mineral : cart.getContent().keySet()){
            orderDetailDAO.saveOrderDetail(mineral, orderMineralEntity, cart.getContent().get(mineral));
        }
        // ici on fait le paiement via paypal
        boolean transactionDone = true;

        if (transactionDone){
            cart.getContent().clear();
            orderMineralEntity.setPaid(true);
            orderMineralDAO.saveOrderMineral(orderMineralEntity);
            return true;
        }
        else{
            return false;
        }
    }
}
