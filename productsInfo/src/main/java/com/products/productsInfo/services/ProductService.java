package com.products.productsInfo.services;

import com.products.productsInfo.entity.Products;
import com.products.productsInfo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(Long id, Products updatedProduct) {
        Products existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {

         productRepository.deleteById(id);
    }
    public Products searchProductByParameters(String productName, Double price) {
        return productRepository.searchProductByParameters(productName, price);
    }

    public Products searchProductByParameters(String productName, Double price, Date minPostedDate, Date maxPostedDate) {
        return productRepository.searchProductByParameters(productName, price,minPostedDate,maxPostedDate);
    }
}

