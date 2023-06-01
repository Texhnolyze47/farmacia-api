package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.entities.User;
import com.texhnolyze.farmacia.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("in the user details service");

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void saveUser(User user,Role role) {
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        logger.info(String.format("Saving user with username %s and de role %s", user.getUsername(), role.getAuthority()));
        userRepository.save(new User(user.getUserId(), user.getUsername(), user.getPassword(), roles));
        logger.info("User with username {} saved successfully", user.getUsername());
    }
}
