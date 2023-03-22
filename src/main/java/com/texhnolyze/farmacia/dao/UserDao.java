package com.texhnolyze.farmacia.dao;

import com.texhnolyze.farmacia.repositories.UserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {


    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails findUserByEmail(String email){
        com.texhnolyze.farmacia.entities.User user = userRepository.findByEmail(email);
        if (user == null){
            throw  new UsernameNotFoundException("No user found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRoles().toArray(new String[0])));
    }
}


