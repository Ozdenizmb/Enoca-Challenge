package com.enoca.challenge.service;

import com.enoca.challenge.dto.ProductCreateDto;
import com.enoca.challenge.dto.ProductDto;
import com.enoca.challenge.dto.ProductUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {

    UUID createProduct(ProductCreateDto productCreateDto);
    ProductDto getProduct(UUID productId);
    Page<ProductDto> getProducts(Pageable pageable);
    Page<ProductDto> getProductsWithName(String name, Pageable pageable);
    Page<ProductDto> getProductsWithCategory(String category, Pageable pageable);
    ProductDto updateProduct(UUID productId, ProductUpdateDto productUpdateDto);
    Boolean deleteProduct(UUID productId);

}
