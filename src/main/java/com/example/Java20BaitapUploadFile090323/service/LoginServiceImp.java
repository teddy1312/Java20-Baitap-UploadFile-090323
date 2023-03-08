package com.example.Java20BaitapUploadFile090323.service;

import com.example.Java20BaitapUploadFile090323.repository.UserRepository;
import com.example.Java20BaitapUploadFile090323.service.Imp.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkLogin(String email, String pass) {

        return userRepository.countByEmailAndPassword(email,pass)>0;
    }
}
