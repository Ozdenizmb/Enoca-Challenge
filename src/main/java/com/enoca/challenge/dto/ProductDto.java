package com.enoca.challenge.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        String description,
        Double price,
        Integer stock,
        String category,
        String brand,
        LocalDate createdDate,
        LocalDate updatedDate
) {
}
