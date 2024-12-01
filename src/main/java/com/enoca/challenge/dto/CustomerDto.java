package com.enoca.challenge.dto;

import java.util.UUID;

public record CustomerDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address
) {
}
