package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.dto.RegistrationDTO;
import com.texhnolyze.farmacia.entities.User;
import com.texhnolyze.farmacia.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO registrationDTO) {
        logger.info("AuthenticationController - registerUser");
        logger.info("info: {}", registrationDTO);
        return authenticationService.registerUser(registrationDTO.username(), registrationDTO.password());
    }

}
