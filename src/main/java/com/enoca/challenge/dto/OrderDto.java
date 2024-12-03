package com.enoca.challenge.dto;

import java.util.List;
import java.util.UUID;

public record OrderDto(
        UUID id,
        CustomerForTransactionDto customer,
        List<ItemForTransactionDto> items,
        Double totalPrice
) {
}
