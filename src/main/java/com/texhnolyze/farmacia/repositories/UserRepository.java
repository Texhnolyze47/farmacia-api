package com.texhnolyze.farmacia.repositories;

import com.texhnolyze.farmacia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
