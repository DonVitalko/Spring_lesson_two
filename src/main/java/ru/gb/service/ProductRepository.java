package ru.gb.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
@Component
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void init(){
        productList.add(new Product(0, "Milk", 10));
        productList.add(new Product(1, "Banana", 5));
        productList.add(new Product(2, "Butter", 17));
        productList.add(new Product(3, "Oil", 50));
        productList.add(new Product(4, "Tomato", 12));
    }

    public List<Product> allList() {
        return new ArrayList<>(productList);
    }

    public Optional<Product> oneProductFromId(int productId) {
        if(productId >= 0 && productId < (productList.size())){
            return Optional.of(productList.get(productId));
        } else {
            return Optional.empty();
        }
    }
}
