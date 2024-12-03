package com.enoca.challenge.dto;

import java.util.UUID;

public record CustomerForTransactionDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address
) {
}
