package com.enoca.challenge.dto;

import java.util.UUID;

public record CartItemForCartDto(
        UUID id,
        ProductForCartDto product,
        Integer quantity
) {
}
