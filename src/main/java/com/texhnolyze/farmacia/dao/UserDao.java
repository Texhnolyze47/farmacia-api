package com.texhnolyze.farmacia.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Repository
public class UserDao {

    private final static List<UserDetails>  USER = Arrays.asList(
            new User(
                    "ivan@mail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "josa@mail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))

            )
    );

    public UserDetails findUserByEmail(String email){
        return USER
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}


