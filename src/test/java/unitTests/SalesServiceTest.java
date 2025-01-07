package com.spring.henallux.firstSpringProject.unitTests;

import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import com.spring.henallux.firstSpringProject.service.SalesService;
import org.junit.Test;
import org.junit.Before;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class SalesServiceTest {
    // calcul du prix en prenant en compte les réductions (-25% sur chaque article dont la quantité est >= 2)

    private SalesService salesService;

    @Before
    public void setup() {
        salesService = new SalesService();
    }

    @Test
    public void getTotalPriceTest(){

        Mineral mineral1 = new Mineral();
        Mineral mineral2 = new Mineral();
        HashMap<Mineral, Integer> content = new HashMap<Mineral, Integer>();


        mineral1.setPrice(11);
        mineral2.setPrice(13);

        content.put(mineral1, 2);
        content.put(mineral2, 3);

        Cart cart = new Cart();
        cart.setContent(content);

        double totalPrice = salesService.getTotalPrice(cart);

        assertEquals(45.75, totalPrice, 0.01);
    }
}
