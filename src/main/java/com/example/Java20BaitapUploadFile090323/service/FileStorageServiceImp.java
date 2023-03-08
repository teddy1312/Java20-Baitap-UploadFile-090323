package com.example.Java20BaitapUploadFile090323.service;

import com.example.Java20BaitapUploadFile090323.service.Imp.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImp implements FileStorageService {
    @Value("${uploads.path}")
    private String path;

    private Path root;

    @Override
    public void init() {
        try {
            root = Paths.get(path);
            System.out.println("Path: "+root);
            if(!Files.exists(root)){
                Files.createDirectories(root);
            }
        } catch (Exception e){
            System.out.println("Error has occurred when create root folder | "+e.getMessage());
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        init();
        try {
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e){
            System.out.println("Error has occurred when copy file | "+e.getMessage());
            return false;
        }
    }
}
