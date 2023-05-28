package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final PasswordEncoder encoder;

    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("in the user details service");

        if (!username.equals("luis")) throw new UsernameNotFoundException("Not luis");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"USER"));
        return new User(1,"luis",encoder.encode("password"),roles);
    }
}
