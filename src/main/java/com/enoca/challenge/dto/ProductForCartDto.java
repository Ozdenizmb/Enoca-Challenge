package com.enoca.challenge.dto;

import java.util.UUID;

public record ProductForCartDto(
        UUID id,
        String name,
        String description,
        Double price,
        Integer stock,
        String category,
        String brand
) {
}
