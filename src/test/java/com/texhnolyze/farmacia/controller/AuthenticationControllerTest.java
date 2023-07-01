package com.texhnolyze.farmacia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.texhnolyze.farmacia.dto.LoginRequestDTO;
import com.texhnolyze.farmacia.dto.LoginResponseDTO;
import com.texhnolyze.farmacia.dto.RegistrationRequestDTO;
import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

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
        RegistrationRequestDTO registrationDTO = new RegistrationRequestDTO("username","email", "password");
        ResponseEntity<String> responseEntity = authenticationController.registerUser(registrationDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("User registered successfully", responseEntity.getBody());
        verify(authenticationService, times(1)).registerUser(registrationDTO.username(), registrationDTO.email(), registrationDTO.password());
    }

    @Test
    void testLoginUser(){
        LoginResponseDTO responseDTO = new LoginResponseDTO("username", "token", new Role("user"));
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO("username", "password");
        when(authenticationService.loginUser(loginRequestDTO.username(), loginRequestDTO.password())).thenReturn(responseDTO);
        ResponseEntity<LoginResponseDTO> responseEntity = authenticationController.loginUser(loginRequestDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseDTO, responseEntity.getBody());
        verify(authenticationService, times(1)).loginUser(loginRequestDTO.username(), loginRequestDTO.password());
    }

}