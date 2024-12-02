package com.enoca.challenge.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record RemoveProductDto(
        @NotNull(message = "Product is required.")
        UUID productId,
        @Positive(message = "Quantity must be a positive value.")
        @NotNull(message = "Quantity is required.")
        Integer quantity
) {
}
