package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDetailDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDetailDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderMineralDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderMineralDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderMineralEntity;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.PaymentService;
import com.spring.henallux.firstSpringProject.service.SalesService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({"cart", "orderMineral"})
public class CartController {
    private PaymentService paymentService;
    private SalesService salesService;

    @Autowired
    public CartController(PaymentService paymentService, SalesService salesService) {
        this.paymentService = paymentService;
        this.salesService = salesService;
    }

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }
    @ModelAttribute("orderMineral")
    public OrderMineralEntity initOrderMineral() {
        return new OrderMineralEntity();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cart(@ModelAttribute("cart") Cart cart,
                       Model model) {
        model.addAttribute("totalPrice", salesService.getTotalPrice(cart));
        return "integrated:cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMineral(
            @ModelAttribute("itemId") int itemId,
            @ModelAttribute("itemName") String itemName,
            @ModelAttribute("itemDensity") int itemDensity,
            @ModelAttribute("itemPrice") double itemPrice,
            @ModelAttribute("itemCategoryId") int itemCategoryId,
            @ModelAttribute("itemImagePath") String itemImagePath,
            @ModelAttribute("cart") Cart cart) {
        Mineral item = new Mineral(itemId, itemName, itemDensity, itemPrice, itemCategoryId, itemImagePath);
        cart.addMineral(item);
        return "redirect:/cart";  // Recharge la même page JSP
    }

    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public String subMineral(
            @ModelAttribute("itemId") int itemId,
            @ModelAttribute("itemName") String itemName,
            @ModelAttribute("itemDensity") int itemDensity,
            @ModelAttribute("itemPrice") double itemPrice,
            @ModelAttribute("itemCategoryId") int itemCategoryId,
            @ModelAttribute("itemImagePath") String itemImagePath,
            @ModelAttribute("cart") Cart cart) {
        Mineral item = new Mineral(itemId, itemName, itemDensity, itemPrice, itemCategoryId, itemImagePath);
        cart.subMineral(item);
        return "redirect:/cart";  // Recharge la même page JSP
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public String subMineral(
            @ModelAttribute("itemId") int itemId,
            @ModelAttribute("itemName") String itemName,
            @ModelAttribute("itemDensity") int itemDensity,
            @ModelAttribute("itemPrice") double itemPrice,
            @ModelAttribute("itemCategoryId") int itemCategoryId,
            @ModelAttribute("itemImagePath") String itemImagePath,
            @ModelAttribute("cart") Cart cart,
            @ModelAttribute("quantity") int quantity) {
        Mineral item = new Mineral(itemId, itemName, itemDensity, itemPrice, itemCategoryId, itemImagePath);
        cart.setMineral(item, quantity);
        return "redirect:/cart";  // Recharge la même page JSP
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeMineral(
            @ModelAttribute("itemId") int itemId,
            @ModelAttribute("itemName") String itemName,
            @ModelAttribute("itemDensity") int itemDensity,
            @ModelAttribute("itemPrice") double itemPrice,
            @ModelAttribute("itemCategoryId") int itemCategoryId,
            @ModelAttribute("itemImagePath") String itemImagePath,
            @ModelAttribute("cart") Cart cart) {
        Mineral item = new Mineral(itemId, itemName, itemDensity, itemPrice, itemCategoryId, itemImagePath);
        cart.removeMineral(item);
        return "redirect:/cart";  // Recharge la même page JSP
    }

    @RequestMapping(value="/redirectToPayPal", method = RequestMethod.POST)
    public String redirectToPayPal(@ModelAttribute("cart") Cart cart,
                                   @ModelAttribute("orderMineral") OrderMineralEntity orderMineralEntity,
                                   Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Vérification si un utilisateur est authentifié
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return "redirect:/login";
        } else {
            if (cart.getContent().size() > 0) {
                orderMineralEntity = paymentService.proceedToPayment(cart, authentication);
                String amount = URLEncoder.encode("" + salesService.getTotalPrice(cart), StandardCharsets.UTF_8);
                model.addAttribute("orderMineral", orderMineralEntity);

                // Construire l'URL PayPal avec les paramètres
                // On doit encoder les url sinon ça ne marche pas
                StringBuilder urlBuilder = new StringBuilder("https://www.sandbox.paypal.com/cgi-bin/webscr");
                urlBuilder.append("?business=sb-iivjt14643753%40business.example.com");

                urlBuilder.append("&cmd=_cart"); // Indique qu'il s'agit d'un panier
                urlBuilder.append("&upload=1"); // Active le mode panier

                // Ajout des articles
                int index = 1; // Compteur pour chaque article
                for (Mineral item : cart.getContent().keySet()) {
                    urlBuilder.append("&item_name_").append(index).append("=").append(URLEncoder.encode(item.getName(), StandardCharsets.UTF_8));
                    if (cart.getContent().get(item) >=2){
                        urlBuilder.append("&amount_").append(index).append("=").append(item.getPrice() * 0.75);
                    }
                    else{
                        urlBuilder.append("&amount_").append(index).append("=").append(item.getPrice());
                    }
                    urlBuilder.append("&quantity_").append(index).append("=").append(cart.getContent().get(item));
                    index++;
                }

                urlBuilder.append("&currency_code=EUR");
                urlBuilder.append("&return=http%3A%2F%2Flocalhost%3A8082%2Fmineral%2Fcart%2Fdone");
                urlBuilder.append("&cancel_return=http%3A%2F%2Flocalhost%3A8082%2Fmineral%2Fcart");

                return "redirect:" + urlBuilder.toString();
            } else {
                return "redirect:/home";
            }
        }
    }
    @RequestMapping(value = "/done", method = RequestMethod.GET)
    public String transactionDone(@ModelAttribute("cart") Cart cart,
                                  @ModelAttribute("orderMineral") OrderMineralEntity orderMineralEntity){
        paymentService.transactionDone(cart, orderMineralEntity);
        return "redirect:/home";
    }
}
