package com.enoca.challenge.dto;

import java.util.UUID;

public record ItemForTransactionDto(
        UUID id,
        ProductForTransactionDto product,
        Integer quantity
) {
}
