package com.products.productsInfo.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
