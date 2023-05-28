package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.entities.User;
import com.texhnolyze.farmacia.repository.RoleRepository;
import com.texhnolyze.farmacia.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username,String password) {
        logger.info("in Authentication Service - register");
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").orElseThrow(() -> new RuntimeException("USER role not found"));
        logger.info("role - user: {} ", userRole);

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new User(0,username,encodedPassword,authorities));
    }

}
