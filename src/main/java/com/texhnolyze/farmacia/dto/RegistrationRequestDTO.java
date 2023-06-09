package com.texhnolyze.farmacia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistrationRequestDTO(
        @NotNull(message = "name cannot be null")
        @NotBlank(message = "name cannot be blank")
        String name,
        @NotNull(message = "Username cannot be null")
        @NotBlank(message = "Username cannot be blank")
        String username,
        @NotNull(message = "Password cannot be null")
        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, max = 20, message = "Password must be between {min} and {max} characters")
        String password
) {
}
