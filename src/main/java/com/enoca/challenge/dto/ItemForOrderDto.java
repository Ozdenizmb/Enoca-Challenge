package com.enoca.challenge.dto;

import java.util.UUID;

public record ItemForOrderDto(
        UUID id,
        ProductForTransactionDto product,
        Double orderProductUnitPrice,
        Integer quantity
) {
}
