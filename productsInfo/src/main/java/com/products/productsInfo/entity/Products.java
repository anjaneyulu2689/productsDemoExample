package com.products.productsInfo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="products")
@Data
public class Products {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Date postedDate;
    private int quantity;
    private String image;
    private String status;

    /*@ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;*/
}
