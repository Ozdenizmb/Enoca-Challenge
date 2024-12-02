package com.enoca.challenge.dto;

import com.enoca.challenge.model.CartItem;
import com.enoca.challenge.model.Customer;

import java.util.List;
import java.util.UUID;

public record CartDto(
        UUID id,
        Customer customer,
        List<CartItem> items,
        Double totalPrice
) {
}
