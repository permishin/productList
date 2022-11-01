package com.example.productlist.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ListWithProductsResponseDto<T> {

    private String name;
    private Integer allKcal;
    private List<T> productsList;

}
