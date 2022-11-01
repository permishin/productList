package com.example.productlist.dto.request;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;
    private String description;
    private Integer kcal;

}
