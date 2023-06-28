package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.dto.LoginRequestDTO;
import com.texhnolyze.farmacia.dto.LoginResponseDTO;
import com.texhnolyze.farmacia.dto.RegistrationRequestDTO;
import com.texhnolyze.farmacia.exceptions.UsernameAlreadyTakenException;
import com.texhnolyze.farmacia.exceptions.UsernameNotFoundException;
import com.texhnolyze.farmacia.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody  RegistrationRequestDTO registrationDTO) {
        logger.info("AuthenticationController - registerUser");
        try {
            authenticationService.registerUser(registrationDTO.username(), registrationDTO.email(), registrationDTO.password());
            logger.trace("info: {}", registrationDTO);
            return ResponseEntity.ok("User registered successfully");
        }catch (UsernameAlreadyTakenException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser (@Validated @RequestBody LoginRequestDTO login) {
        try {
            LoginResponseDTO user = authenticationService.loginUser(login.username(), login.password());
            logger.trace("user info: {}", user);
            return ResponseEntity.ok(user);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
