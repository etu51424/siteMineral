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

    public HashMap<Mineral, Integer> subMineral(Mineral mineral){
        for (Mineral mineralInCart : content.keySet()){
            if (mineralInCart.getId() == mineral.getId()){
                if (content.get(mineralInCart) - 1 == 0){
                    content.remove(mineralInCart);
                }
                else{
                    content.put(mineralInCart, content.get(mineralInCart) - 1);
                }
                return content;
            }
        }
        return content;
    }
    public HashMap<Mineral, Integer> removeMineral(Mineral mineral){
        for (Mineral mineralInCart : content.keySet()){
            if (mineralInCart.getId() == mineral.getId()){
                    content.remove(mineralInCart);
                return content;
            }
        }
        return content;
    }

    public boolean isInCart(Mineral mineral){
        for (Mineral mineralInCart : content.keySet()){
            if (mineralInCart.getId() == mineral.getId()) return true;
        }
        return false;
    }

    public int getValueById(int id){
        for (Mineral mineralInCart : content.keySet()){
            if (mineralInCart.getId() == id) return content.get(mineralInCart);
        }
        return 0;
    }
}
