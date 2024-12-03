package com.enoca.challenge.dto;

import java.util.UUID;

public record ItemForCartDto(
        UUID id,
        ProductForTransactionDto product,
        Integer quantity
) {
}
