package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.dto.RegistrationDTO;
import com.texhnolyze.farmacia.exceptions.UsernameAlreadyTakenException;
import com.texhnolyze.farmacia.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;


    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Validated @RequestBody RegistrationDTO registrationDTO) {
        logger.info("AuthenticationController - registerUser");
        try {
            authenticationService.registerUser(registrationDTO.username(), registrationDTO.password());
            logger.trace("info: {}", registrationDTO);
            return ResponseEntity.ok("User registered successfully");
        }catch (UsernameAlreadyTakenException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
