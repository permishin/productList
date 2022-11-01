package com.example.productlist.service;

import com.example.productlist.dto.request.ProductRequestDto;
import com.example.productlist.dto.response.SuccessAnswerResponseDto;
import com.example.productlist.entity.ProductEntity;
import com.example.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public SuccessAnswerResponseDto addProduct(ProductRequestDto product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setKcal(product.getKcal());
        productRepository.save(productEntity);
        return SuccessAnswerResponseDto.builder()
                .message("Product added")
                .status("OK")
                .build();
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
