package com.example.productlist.controller;

import com.example.productlist.dto.request.ListRequestDto;
import com.example.productlist.dto.request.ProductToListRequestDto;
import com.example.productlist.dto.response.ListWithProductsResponseDto;
import com.example.productlist.dto.response.SuccessResponseDto;
import com.example.productlist.entity.ListEntity;
import com.example.productlist.entity.ProductEntity;
import com.example.productlist.service.ListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/lists")
@Tag(name = "Контроллер для работы с листом", description = "Вывод списка листов, вывод по id, " +
        "добавление нового листа, запись продукта в лист")
public class ListController {

    private ListService listService;

    @Operation(summary = "Вывести список всех листов")

    @GetMapping()
    public ResponseEntity<List<ListEntity>> getAllLists() {
        return new ResponseEntity<>(listService.getAllLists(), HttpStatus.OK);
    }

    @Operation(summary = "Вывести лист по id со всеми принадлежащими ему продуктами")
    @GetMapping("/{id}")
    public ResponseEntity<ListWithProductsResponseDto<ProductEntity>> getListWithProduct(@PathVariable Long id) {
        return new ResponseEntity<>(listService.getListWithProducts(id), HttpStatus.OK);
    }

    @Operation(summary = "Добавить новый лист")
    @PutMapping("/add")
    public ResponseEntity<SuccessResponseDto> addList(@RequestBody ListRequestDto listRequest) {
        return new ResponseEntity<>(listService.addList(listRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Записать продукт в лист")
    @PutMapping("/addProduct")
    public ResponseEntity<SuccessResponseDto> addProductToList(@RequestBody ProductToListRequestDto request) {
        return new ResponseEntity<>(listService.addProductLoList(request), HttpStatus.OK);
    }

}
