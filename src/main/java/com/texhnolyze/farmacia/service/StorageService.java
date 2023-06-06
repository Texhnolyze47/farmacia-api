package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.FileData;
import com.texhnolyze.farmacia.repository.FileDataRepository;
import com.texhnolyze.farmacia.repository.StorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class StorageService {

    private StorageRepository storageRepository;
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "src/main/resources/static";

    public StorageService(StorageRepository storageRepository, FileDataRepository fileDataRepository) {
        this.storageRepository = storageRepository;
        this.fileDataRepository = fileDataRepository;
    }

    public String uploadImageFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .build());
        file.transferTo(new File(filePath));
        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }
}
