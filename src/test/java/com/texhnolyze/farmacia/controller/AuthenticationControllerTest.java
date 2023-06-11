package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.dto.RegistrationRequestDTO;
import com.texhnolyze.farmacia.service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class AuthenticationControllerTest {
    private AuthenticationController authenticationController;

    @Mock
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationController = new AuthenticationController(authenticationService);
    }

    @Test
    void testRegisterUser() {
        RegistrationRequestDTO registrationDTO = new RegistrationRequestDTO("name","username", "password");
        ResponseEntity<String> responseEntity = authenticationController.registerUser(registrationDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("User registered successfully", responseEntity.getBody());
        verify(authenticationService, times(1)).registerUser(registrationDTO.name(),registrationDTO.username(), registrationDTO.password());
    }

}