package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Buyer {

    private final ShopControllerImpl shopController;

    @PostConstruct
    public void init(){
        shopController.enterToShop();
    }

    public void purchase(){
        Random random = new Random();

        int productNumber = random.nextInt(9) + 2;
        System.out.println("Buyer want to buy " + productNumber + " products");
        for (int i = 0; i < productNumber; i++) {
            shopController.addProductCartById(random.nextInt(5));
        }
        shopController.deleteProductFromCartById(random.nextInt(5));
    }

    public void showCart(){
        System.out.println("Buyer bought ");
        shopController.showProductInCart();
        System.out.println("--------------------------------");
    }
}
