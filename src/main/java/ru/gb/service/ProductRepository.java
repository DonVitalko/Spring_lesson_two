package ru.gb.service;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.Arrays;
import java.util.List;

@Getter
@Component
public class ProductRepository {

    List<Product> productList = Arrays.asList(
            new Product(1,"Milk", 10),
            new Product(2,"Banana", 5),
            new Product(3,"Butter", 17),
            new Product(4,"Oil", 50),
            new Product(5,"Tomato", 12)
    );

    public void allList(){
        for (Product product:productList) {
            System.out.println(product);
        }
    }

    public Product oneProductFromId(int productId){
        return productList.get(productId-1);
    }
}
