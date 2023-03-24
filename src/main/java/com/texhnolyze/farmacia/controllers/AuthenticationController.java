package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.config.JwtUtils;
import com.texhnolyze.farmacia.dao.UserDao;
import com.texhnolyze.farmacia.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;

    private Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final JwtUtils jwtUtils;
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),
                authenticationRequest.getPassword())
        );
        log.trace("El usuario con el correo " + authenticationRequest.getEmail());
        final UserDetails user = userDao.findUserByEmail(authenticationRequest.getEmail());
        if (user != null){
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        log.trace("El token que se genero es: " + jwtUtils.generateToken(user));
        return ResponseEntity.status(400).body("Some error has occurred");
    }
}
