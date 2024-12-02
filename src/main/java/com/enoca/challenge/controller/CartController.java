package com.enoca.challenge.controller;

import com.enoca.challenge.api.CartApi;
import com.enoca.challenge.dto.AddProductDto;
import com.enoca.challenge.dto.CartDto;
import com.enoca.challenge.dto.RemoveProductDto;
import com.enoca.challenge.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class CartController implements CartApi {

    private final CartService service;

    @Override
    public ResponseEntity<CartDto> getCart(UUID customerId) {
        return ResponseEntity.ok(service.getCart(customerId));
    }

    @Override
    public ResponseEntity<CartDto> AddProductToCart(UUID customerId, AddProductDto addProductDto) {
        return ResponseEntity.ok(service.AddProductToCart(customerId, addProductDto));
    }

    @Override
    public ResponseEntity<CartDto> RemoveProductFromCart(UUID customerId, RemoveProductDto removeProductDto) {
        return ResponseEntity.ok(service.RemoveProductFromCart(customerId, removeProductDto));
    }

}
