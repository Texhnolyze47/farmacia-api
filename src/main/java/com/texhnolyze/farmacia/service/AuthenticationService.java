package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.dto.LoginResponseDTO;
import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.entities.User;
import com.texhnolyze.farmacia.exceptions.UsernameAlreadyTakenException;
import com.texhnolyze.farmacia.repository.RoleRepository;
import com.texhnolyze.farmacia.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public User registerUser(String username,String password) {
        logger.info("in Authentication Service - register");
        if (isUsersExists(username)) {
            throw new UsernameAlreadyTakenException("Username already taken");
        }
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").orElseThrow(() -> new RuntimeException("USER role not found"));
        logger.info("role - user: {} ", userRole);

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new User(0,username,encodedPassword,authorities));

    }

    public LoginResponseDTO loginUser(String username, String password) {
            logger.info("login user: {} -- {}", username, password );
            if (!isUsersExists(username)) {
                throw new UsernameNotFoundException("User not found");
            }
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            String token = tokenService.generateJwt(auth);
            return new LoginResponseDTO(username,token);
    }

    private boolean isUsersExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

}
