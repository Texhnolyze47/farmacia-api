package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class StorageController {

    private StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImageFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
}
