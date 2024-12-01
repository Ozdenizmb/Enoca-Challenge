package com.enoca.challenge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerCreateDto(
        @NotBlank(message = "First name cannot be blank")
        @NotNull(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name cannot be blank")
        @NotNull(message = "Last name is required")
        String lastName,
        @Email(message = "Please provide a valid email address")
        @NotBlank(message = "Email cannot be blank")
        @NotNull(message = "Email is required")
        String email,
        @NotBlank(message = "Password cannot be blank")
        @NotNull(message = "Password is required")
        String password,
        @Pattern(regexp = "^0[0-9]{10}$", message = "Phone number must start with '0' and contain 11 digits")
        @NotBlank(message = "Phone number cannot be blank")
        @NotNull(message = "Phone number is required")
        String phone,
        @NotBlank(message = "Address cannot be blank")
        @NotNull(message = "Address is required")
        String address
) {
}
