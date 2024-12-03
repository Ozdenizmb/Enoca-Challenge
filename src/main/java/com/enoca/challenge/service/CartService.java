package com.enoca.challenge.service;

import com.enoca.challenge.dto.AddProductDto;
import com.enoca.challenge.dto.CartDto;
import com.enoca.challenge.dto.RemoveProductDto;

import java.util.UUID;

public interface CartService {

    CartDto getCart(UUID customerId);
    void emptyCart(UUID customerId);
    CartDto addProductToCart(UUID customerId, AddProductDto addProductDto);
    CartDto removeProductFromCart(UUID customerId, RemoveProductDto removeProductDto);

}
