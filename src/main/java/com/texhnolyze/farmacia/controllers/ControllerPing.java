package com.texhnolyze.farmacia.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ControllerPing {
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
