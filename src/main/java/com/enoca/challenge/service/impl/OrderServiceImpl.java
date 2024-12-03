package com.enoca.challenge.service.impl;

import com.enoca.challenge.model.Product;
import com.enoca.challenge.repository.OrderRepository;
import com.enoca.challenge.repository.ProductRepository;
import com.enoca.challenge.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;

    private void restockRemovedItems(UUID productId, int quantity) {
        Optional<Product> responseProduct = productRepository.findById(productId);

        if(responseProduct.isPresent()) {
            Product product = responseProduct.get();
            product.setStock(product.getStock() + quantity);
            productRepository.save(product);
        }
    }

}
