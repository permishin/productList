package com.example.productlist.service;

import com.example.productlist.dto.request.ListRequestDto;
import com.example.productlist.dto.request.ProductToListRequestDto;
import com.example.productlist.dto.response.ListWithProductsResponseDto;
import com.example.productlist.dto.response.SuccessResponseDto;
import com.example.productlist.entity.ListEntity;
import com.example.productlist.entity.ListToProduct;
import com.example.productlist.entity.ProductEntity;
import com.example.productlist.repository.ListRepository;
import com.example.productlist.repository.ListToProductRepository;
import com.example.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ListService {

    private ListRepository listRepository;
    private ListToProductRepository listToProductRepository;
    private ProductRepository productRepository;

    public SuccessResponseDto addList(ListRequestDto listName) {
        ListEntity listEntity = new ListEntity();
        listEntity.setName(listName.getName());
        listRepository.save(listEntity);
        return SuccessResponseDto.builder()
                .message("List '" + listName.getName() + "' created")
                .status("CREATED")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public List<ListEntity> getAllLists() {
        return listRepository.findAll();
    }

    public SuccessResponseDto addProductLoList(ProductToListRequestDto request) {
        ListToProduct listToProduct = new ListToProduct();
        listToProduct.setList(listRepository.findById(request.getListId()).orElseThrow());
        listToProduct.setProduct(productRepository.findById(request.getProductId()).orElseThrow());
        listToProductRepository.save(listToProduct);
        return SuccessResponseDto.builder()
                .message("Product '" + listToProduct.getProduct().getName() +
                        "' added to '" + listToProduct.getList().getName() + "' list")
                .status("OK")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public ListWithProductsResponseDto<ProductEntity> getListWithProducts(Long id) {
        ListEntity list = listRepository.findById(id).orElseThrow();
        List<ProductEntity> products = listToProductRepository.findAllProduct(id);
        Integer allKcal = products.stream().mapToInt(ProductEntity::getKcal).sum();
        return ListWithProductsResponseDto.<ProductEntity>builder()
                .name(list.getName())
                .allKcal(allKcal)
                .productsList(products)
                .build();
    }
}
