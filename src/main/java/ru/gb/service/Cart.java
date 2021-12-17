package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    @Autowired
    ProductRepository productRepository;

    int change;

    List<Product> cart = new ArrayList<>();

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void martControl() throws IOException {
        while (change != 6) {
            System.out.println("------------------------------------\n" +
                    "Выберите нужный пункт меню\n" +
                    "1.Показать весь список товаров.\n" +
                    "2.Показать товар с номером.\n" +
                    "3.Добавить товар в корзину\n" +
                    "4.Удалить товар из корзины\n" +
                    "5.Показать корзину.\n" +
                    "6.Выйти.");
            change = Integer.parseInt(bufferedReader.readLine());
            if (change == 1) {
                productRepository.allList();
            }
            if (change == 2) {
                System.out.println(productRepository.oneProductFromId(changeIdProduct()));
            }
            if (change == 3) {
                addCart(changeIdProduct());//Не смог придумать как вставить в коллекцию по id.
            }
            if (change == 4) {
                remove(changeIdProduct());
            }
            if (change == 5) {
                showCart();
            }
            if (change == 6) {
                break;
            }
        }
    }

    public int changeIdProduct() throws IOException {
        int id;
        System.out.println("Введите номер товара:");
        id = Integer.parseInt(bufferedReader.readLine());
        return id;
    }

    public void addCart(int productId){
        cart.add(productRepository.oneProductFromId(productId));
    }

    public void remove(int productId){
        cart.remove(productId);
    }

    public void showCart() {
        if(cart.size() == 0){
            System.out.println("Корзина пуста.");
        } else {
            for (Product product : cart) {
                System.out.println(product);
            }
        }
    }
}
