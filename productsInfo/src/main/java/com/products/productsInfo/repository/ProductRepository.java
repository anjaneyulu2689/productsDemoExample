package com.products.productsInfo.repository;

import com.products.productsInfo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ProductRepository  extends JpaRepository<Products,Long>{

    @Query("select p from Products p where p.name=:productName and p.price=:price")

    Products searchProductByParameters(@Param("productName") String productName,
                                       @Param("price")Double price);
    @Query("select p from Products p where p.name=:productName and p.price=:price and p.postedDate between :minPostedDate and :maxPostedDate")

    Products searchProductByParameters(@Param("productName") String productName,
                                       @Param("price")Double price,
                                       @Param("minPostedDate") Date minPostedDate,
                                       @Param("maxPostedDate") Date maxPostedDate);
}
