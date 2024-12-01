package com.enoca.challenge.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductUpdateDto(
        @Size(max = 50, message = "Name cannot exceed 50 characters.")
        @NotBlank(message = "Name cannot be blank.")
        @NotNull(message = "Name is required.")
        String name,
        @Size(max = 255, message = "Description cannot exceed 255 characters.")
        @NotBlank(message = "Description cannot be blank.")
        @NotNull(message = "Description is required.")
        String description,
        @DecimalMin(value = "0.0", message = "Price must be a positive value.")
        @NotNull(message = "Price is required.")
        Double price,
        @Positive(message = "Stock must be a positive value.")
        @NotNull(message = "Stock is required.")
        Integer stock,
        @NotBlank(message = "Category cannot be blank.")
        @NotNull(message = "Category is required.")
        String category,
        @Size(max = 30, message = "Brand cannot exceed 30 characters.")
        @NotBlank(message = "Brand cannot be blank.")
        @NotNull(message = "Brand is required.")
        String brand
) {
}
