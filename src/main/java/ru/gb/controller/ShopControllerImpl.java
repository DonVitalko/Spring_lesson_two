package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import ru.gb.service.Cart;
import ru.gb.service.ProductRepository;


@RequiredArgsConstructor
@Component
public class ShopControllerImpl implements ShopController{
    private final ProductRepository productRepository;
    private Cart cart;

    int change;

    @Lookup
    @Override
    public Cart getCart(){
        return null;
    }

    public void ShowAssortment(){
        System.out.println(productRepository.allList());
    }

    public void addProductCartById(Integer productId){
        productRepository.oneProductFromId(productId).ifPresent(cart);
    }

    public void deleteProductFromCartById(Integer productId){
        cart.remove(productId);
    }

    public void showProductInCart(){
        cart.showCart();
    }

    public void enterToShop(){
        this.cart = getCart();
    }


//    public Product changeIdProduct() throws IOException {
//        int id;
//        System.out.println("Введите номер товара:");
//        id = Integer.parseInt(bufferedReader.readLine());
//        return cart.get(id);
//    }
//
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//    public void martControl() throws IOException {
//        while (change != 6) {
//            System.out.println("------------------------------------\n" +
//                    "Выберите нужный пункт меню\n" +
//                    "1.Показать весь список товаров.\n" +
//                    "2.Показать товар с номером.\n" +
//                    "3.Добавить товар в корзину\n" +
//                    "4.Удалить товар из корзины\n" +
//                    "5.Показать корзину.\n" +
//                    "6.Выйти.");
//            change = Integer.parseInt(bufferedReader.readLine());
//            if (change == 1) {
//                System.out.println(productRepository.allList());
//            }
//            if (change == 2) {
//                System.out.println(productRepository.oneProductFromId(changeIdProduct()));
//            }
//            if (change == 3) {
//                addCart(changeIdProduct());
//            }
//            if (change == 4) {
//                remove(changeIdProduct());
//            }
//            if (change == 5) {
//                showCart();
//            }
//            if (change == 6) {
//                break;
//            }
//        }
//    }
}
