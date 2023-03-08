package com.example.Java20BaitapUploadFile090323.service;

import com.example.Java20BaitapUploadFile090323.entity.Foods;
import com.example.Java20BaitapUploadFile090323.repository.FoodRepository;
import com.example.Java20BaitapUploadFile090323.service.Imp.FileStorageService;
import com.example.Java20BaitapUploadFile090323.service.Imp.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FileStorageService fileStorageService;

    @Override
    public boolean addMenu(MultipartFile file, Foods food) {
        try {
            Foods newFood = new Foods();
            newFood.setName(food.getName());
            newFood.setDescription(food.getDescription());
            newFood.setPrice(food.getPrice());
            newFood.setInstruction(food.getInstruction());
            newFood.setCategory(food.getCategory());

            if(fileStorageService.saveFile(file)){
                newFood.setImage(file.getOriginalFilename());
                foodRepository.save(newFood);
                System.out.println("File saved successfully");
                return true;
            } else {
                System.out.println("File save failed");
            }
        } catch (Exception e){
            System.out.println("Error has occurred when add menu | " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Foods> getAllMenu() {

        return foodRepository.findAllBy();
    }
}
