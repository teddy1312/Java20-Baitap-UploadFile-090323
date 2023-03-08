package com.example.Java20BaitapUploadFile090323.controller;

import com.example.Java20BaitapUploadFile090323.entity.Foods;
import com.example.Java20BaitapUploadFile090323.payload.DataResponse;
import com.example.Java20BaitapUploadFile090323.repository.FoodRepository;
import com.example.Java20BaitapUploadFile090323.service.Imp.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping("/add")
    public ResponseEntity<?> addFood2Menu(@RequestPart Foods food, @RequestPart MultipartFile file){
        DataResponse dataResponse = new DataResponse();
        if(menuService.addMenu(file,food)){
            dataResponse.setStatus(200);
            dataResponse.setDescription("Thêm menu mới thành công");
            dataResponse.setData(true);
        } else {
            dataResponse.setStatus(400);
            dataResponse.setDescription("Thêm menu mới thất bại");
            dataResponse.setData(false);
        }

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllMenu(){
        DataResponse dataResponse = new DataResponse();

        dataResponse.setStatus(200);
        dataResponse.setDescription("Lấy danh sách menu thành công");
        dataResponse.setData(menuService.getAllMenu());

        return new ResponseEntity<>(dataResponse,HttpStatus.OK);
    }
}
