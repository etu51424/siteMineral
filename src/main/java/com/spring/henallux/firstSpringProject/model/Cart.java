package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.Min;
import java.util.HashMap;

public class Cart {
    private HashMap<Mineral, Integer> content;

    public Cart(){
        this.content = new HashMap<>();
    }


    public HashMap<Mineral, Integer> getContent() {
        return content;
    }
    public HashMap<Mineral, Integer> addMineral(Mineral mineral){
        for (Mineral mineralInCart : content.keySet()){
            if (mineralInCart.getId() == mineral.getId()){
                content.put(mineralInCart, content.get(mineralInCart) + 1);
                return content;
            }
        }
        content.put(mineral, 1);
        return content;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (Mineral mineral : content.keySet()){
            totalPrice += content.get(mineral) * mineral.getPrice();
        }
        return totalPrice;
    }
}
