package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Role;
import com.texhnolyze.farmacia.entities.User;
import com.texhnolyze.farmacia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getlevel() {
        return "Admin level";
    }

    @PutMapping("/{username}/role")
    public ResponseEntity<String> changeRole(@PathVariable String username,@RequestBody Role role) {
        Optional<User> existUser = userService.findUserByUsername(username);
        if (existUser.isPresent()) {
            User user = existUser.get();
            logger.info("User - set  {}", user);
            userService.saveUser(user,role);
            logger.info("user - final {}", user);
            return ResponseEntity.ok("Changed role");
        }
        return ResponseEntity.badRequest().body("failed to update role");
    }
}
