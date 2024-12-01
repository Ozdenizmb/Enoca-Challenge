package com.enoca.challenge.service.impl;

import com.enoca.challenge.dto.ProductCreateDto;
import com.enoca.challenge.dto.ProductDto;
import com.enoca.challenge.dto.ProductUpdateDto;
import com.enoca.challenge.exception.EnocaException;
import com.enoca.challenge.exception.ErrorMessages;
import com.enoca.challenge.mapper.PageMapperHelper;
import com.enoca.challenge.mapper.ProductMapper;
import com.enoca.challenge.model.Product;
import com.enoca.challenge.repository.ProductRepository;
import com.enoca.challenge.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public UUID createProduct(ProductCreateDto productCreateDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreateDto, product);
        return repository.save(product).getId();
    }

    @Override
    public ProductDto getProduct(UUID productId) {
        Optional<Product> responseProduct = repository.findById(productId);

        if(responseProduct.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PRODUCT_NOT_FOUND);
        }

        return mapper.toDto(responseProduct.get());
    }

    @Override
    public Page<ProductDto> getProducts(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);

        if(products.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PRODUCT_NOT_FOUND);
        }

        return PageMapperHelper.mapEntityPageToDtoPage(products, mapper);
    }

    @Override
    public Page<ProductDto> getProductsWithName(String name, Pageable pageable) {
        Page<Product> products = repository.findAllByNameContainingIgnoreCase(name, pageable);

        if(products.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PRODUCT_NOT_FOUND);
        }

        return PageMapperHelper.mapEntityPageToDtoPage(products, mapper);
    }

    @Override
    public Page<ProductDto> getProductsWithCategory(String category, Pageable pageable) {
        Page<Product> products = repository.findAllByCategoryContainingIgnoreCase(category, pageable);

        if(products.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PRODUCT_NOT_FOUND);
        }

        return PageMapperHelper.mapEntityPageToDtoPage(products, mapper);
    }

    @Override
    public ProductDto updateProduct(UUID productId, ProductUpdateDto productUpdateDto) {
        Optional<Product> responseProduct = repository.findById(productId);

        if(responseProduct.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PRODUCT_NOT_FOUND);
        }

        Product product = responseProduct.get();
        BeanUtils.copyProperties(productUpdateDto, product);

        return mapper.toDto(repository.save(product));
    }

    @Override
    public Boolean deleteProduct(UUID productId) {
        Optional<Product> responseProduct = repository.findById(productId);

        if(responseProduct.isEmpty()) {
            throw EnocaException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PRODUCT_NOT_FOUND);
        }

        repository.delete(responseProduct.get());

        return true;
    }
}
