package com.products.productsInfo;

import com.products.productsInfo.entity.Products;
import com.products.productsInfo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SampleDataLoader implements CommandLineRunner {
    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        // Create and save sample products
        Products product1 = new Products();
        product1.setName("Product 3");
        product1.setDescription("Description for Product 3");
        product1.setPrice(29.99);
        product1.setQuantity(10);
        product1.setPostedDate(new Date());

        Products product2 = new Products();
        product2.setName("Product 3");
        product2.setDescription("Description for Product 4");
        product2.setPrice(49.99);
        product2.setQuantity(5);
        product2.setPostedDate(new Date());

       // productService.createProduct(product1);
        // productService.createProduct(product2);
    }
}
