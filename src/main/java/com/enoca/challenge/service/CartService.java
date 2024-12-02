package com.enoca.challenge.service;

import com.enoca.challenge.dto.AddProductDto;
import com.enoca.challenge.dto.CartDto;
import com.enoca.challenge.dto.RemoveProductDto;

import java.util.UUID;

public interface CartService {

    CartDto getCart(UUID customerId);
    CartDto AddProductToCart(UUID customerId, AddProductDto addProductDto);
    CartDto RemoveProductFromCart(UUID customerId, RemoveProductDto removeProductDto);

}
