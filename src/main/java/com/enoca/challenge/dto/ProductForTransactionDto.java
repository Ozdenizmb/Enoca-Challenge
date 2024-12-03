package com.enoca.challenge.dto;

import java.util.UUID;

public record ProductForTransactionDto(
        UUID id,
        String name,
        String description,
        Double price,
        Integer stock,
        String category,
        String brand
) {
}
