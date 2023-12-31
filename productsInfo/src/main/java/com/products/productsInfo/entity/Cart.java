package com.products.productsInfo.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> products;


    public Cart() {
        products = new ArrayList<>();
    }
}