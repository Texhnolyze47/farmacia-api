package com.texhnolyze.farmacia.config;

import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleLoader implements CommandLineRunner {
    private final RoleRepository repository;

    public RoleLoader(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        Role doctorRole = new Role("DOCTOR");
        Role supportRole = new Role("SUPPORT");
        Role sellerRole = new Role("SELLER");
        repository.saveAll(Arrays.asList(adminRole, userRole,doctorRole,supportRole,sellerRole));
    }
}
