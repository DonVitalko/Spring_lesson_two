package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {

    private final Map<Integer, Product> cart = new HashMap<>();

    public void addCart(Product productId) {
        cart.put(productId.getId(), productId);
    }

    public void remove(int productId) {
        cart.remove(productId);
    }

    public void showCart() {
            System.out.println(cart);
    }

    @Override
    public void accept(Product product) {
        addCart(product);
    }
}
