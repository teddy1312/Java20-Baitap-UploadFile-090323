package com.example.Java20BaitapUploadFile090323.service.Imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void init();
    boolean saveFile(MultipartFile file);
}
