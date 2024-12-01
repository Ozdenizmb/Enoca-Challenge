package com.enoca.challenge.controller;

import com.enoca.challenge.api.ProductApi;
import com.enoca.challenge.dto.ProductCreateDto;
import com.enoca.challenge.dto.ProductDto;
import com.enoca.challenge.dto.ProductUpdateDto;
import com.enoca.challenge.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class ProductController implements ProductApi {

    private final ProductService service;

    @Override
    public ResponseEntity<UUID> createProduct(ProductCreateDto productCreateDto) {
        return ResponseEntity.ok(service.createProduct(productCreateDto));
    }

    @Override
    public ResponseEntity<ProductDto> getProduct(UUID productId) {
        return ResponseEntity.ok(service.getProduct(productId));
    }

    @Override
    public ResponseEntity<Page<ProductDto>> getProducts(Pageable pageable) {
        return ResponseEntity.ok(service.getProducts(pageable));
    }

    @Override
    public ResponseEntity<Page<ProductDto>> getProductsWithName(String name, Pageable pageable) {
        return ResponseEntity.ok(service.getProductsWithName(name, pageable));
    }

    @Override
    public ResponseEntity<Page<ProductDto>> getProductsWithCategory(String category, Pageable pageable) {
        return ResponseEntity.ok(service.getProductsWithCategory(category, pageable));
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(UUID productId, ProductUpdateDto productUpdateDto) {
        return ResponseEntity.ok(service.updateProduct(productId, productUpdateDto));
    }

    @Override
    public ResponseEntity<Boolean> deleteProduct(UUID productId) {
        return ResponseEntity.ok(service.deleteProduct(productId));
    }

}
