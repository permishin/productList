package com.example.productlist.controller;


import com.example.productlist.dto.request.ProductRequestDto;
import com.example.productlist.dto.response.SuccessResponseDto;
import com.example.productlist.entity.ProductEntity;
import com.example.productlist.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Контроллер для работы с продуктом", description = "Вывод списка продуктов, добавление нового продукта")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Вывести список всех продуктов")
    @GetMapping()
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @Operation(summary = "Добавить новый продукт")
    @PutMapping("/add")
    public ResponseEntity<SuccessResponseDto> addProduct(@RequestBody ProductRequestDto product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

}
