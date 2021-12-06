package ru.gb.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.service.Cart;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to my mart.");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Cart cart = context.getBean(Cart.class);
        cart.martControl();
        context.close();

        System.out.println("Good Bye!!!");

    }
}
