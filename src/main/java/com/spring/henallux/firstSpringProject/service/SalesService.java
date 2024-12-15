package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SalesService {

    // calcul du prix en prenant en compte les réductions (-25% sur chaque article dont la quantité est >= 2)
    public double getTotalPrice(Cart cart){
        double totalPrice = 0;
        for (Mineral mineral : cart.getContent().keySet()){
            if (cart.getContent().get(mineral) >= 2){
                totalPrice += (cart.getContent().get(mineral) * mineral.getPrice()) * 0.75;
            }
            else {
                totalPrice += cart.getContent().get(mineral) * mineral.getPrice();
            }
        }
        return totalPrice;
    }

}
