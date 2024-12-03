package com.enoca.challenge.dto;

import java.util.List;
import java.util.UUID;

public record CartDto(
        UUID id,
        CustomerForCartDto customer,
        List<CartItemForCartDto> items,
        Double totalPrice
) {
}
