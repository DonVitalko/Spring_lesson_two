package ru.gb.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.*;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {

    private final ListMultimap<Integer, Product> cart = ArrayListMultimap.create();

    public void addCart(Product productId) {
        cart.put(productId.getId(), productId);
    }

    public void remove(int productId) {
        cart.remove(productId, productId);
    }

    public void showCart() {
            System.out.println(cart);
    }

    @Override
    public void accept(Product product) {
        addCart(product);
    }
}
