package com.enoca.challenge.dto;

import java.util.UUID;

public record CustomerForCartDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address
) {
}
