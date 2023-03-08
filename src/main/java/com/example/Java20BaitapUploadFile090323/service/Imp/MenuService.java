package com.example.Java20BaitapUploadFile090323.service.Imp;

import com.example.Java20BaitapUploadFile090323.entity.Foods;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MenuService {
    boolean addMenu(MultipartFile file, Foods food);
    List<Foods> getAllMenu();
}
