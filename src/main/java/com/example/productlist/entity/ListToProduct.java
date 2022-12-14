package com.example.productlist.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "list_to_product")
public class ListToProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "list_id")
    private ListEntity list;
    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

}