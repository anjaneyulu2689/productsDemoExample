package com.products.productsInfo.controller;

import com.products.productsInfo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.products.productsInfo.entity.Products;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Products> getAllProducts() {

        return productService.getAllProducts();
    }
    @GetMapping("/search")
    public ResponseEntity<Products> searchProductByNamePrice(@RequestParam("name") String productName,
                                                              @RequestParam("price") Double price) {
        Products product = productService.searchProductByParameters(productName,price);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/searchByAll")
    public ResponseEntity<Products> searchProductByParameters(@RequestParam("name") String productName,
                                                         @RequestParam("price") Double price,
                                                         @RequestParam(value="minPostedDate",required=false) Date minPostedDate,
                                                         @RequestParam(value="maxPostedDate",required=false) Date maxPostedDate) {
        Products product = productService.searchProductByParameters(productName,price,minPostedDate,maxPostedDate);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Products product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products createdProduct = productService.createProduct(product);
        return ResponseEntity.created(URI.create("/api/products/" + createdProduct.getId())).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products updatedProduct) {
        Products product = productService.updateProduct(id, updatedProduct);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "product deleted successfully";
    }
}

