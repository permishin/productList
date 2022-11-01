package com.example.productlist.service;

import com.example.productlist.dto.request.ProductRequestDto;
import com.example.productlist.dto.response.SuccessResponseDto;
import com.example.productlist.entity.ProductEntity;
import com.example.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public SuccessResponseDto addProduct(ProductRequestDto product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setKcal(product.getKcal());
        productRepository.save(productEntity);
        return SuccessResponseDto.builder()
                .message("Product '" + product.getName() + "' created")
                .status("CREATED")
                .timestamp(LocalDateTime.now())
                .build();
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
