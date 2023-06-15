package com.texhnolyze.farmacia.config;

import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleLoader implements CommandLineRunner {
    private final RoleRepository repository;

    public RoleLoader(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = Arrays.asList(
                new Role("ADMIN"),
                new Role("USER"),
                new Role("DOCTOR"),
                new Role("SUPPORT"),
                new Role("SELLER")
        );

        for (Role role : roles) {
            if (!repository.existsByAuthority(role.getAuthority())) {
                repository.save(role);
            }
        }
    }

}
