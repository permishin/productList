package com.example.productlist.repository;

import com.example.productlist.entity.ListToProduct;
import com.example.productlist.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListToProductRepository extends JpaRepository<ListToProduct, Long> {

    @Query("""
            SELECT l.product
            FROM ListToProduct as l
            WHERE l.list.id = :id
            """)
    List<ProductEntity> findAllProduct(Long id);
}
