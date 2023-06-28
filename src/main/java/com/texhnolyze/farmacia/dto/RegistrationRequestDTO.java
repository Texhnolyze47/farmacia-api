package com.texhnolyze.farmacia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistrationRequestDTO(

        @NotNull(message = "username cannot be null")
        @NotBlank(message = "username cannot be blank")
        String username,
        @NotNull(message = "Password cannot be null")
        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, max = 20, message = "Password must be between {min} and {max} characters")
        String password
) {
}
