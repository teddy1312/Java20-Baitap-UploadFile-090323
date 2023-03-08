package com.example.Java20BaitapUploadFile090323.controller;

import com.example.Java20BaitapUploadFile090323.payload.DataResponse;
import com.example.Java20BaitapUploadFile090323.utils.JwtUtils;
import com.google.gson.Gson;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email,password);

        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            if(authentication != null){
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(authentication);

                Gson gson = new Gson();
                String username = gson.toJson(authentication.getName());

                DataResponse dataResponse = jwtUtils.generateToken(username);
                return new ResponseEntity<>(dataResponse,HttpStatus.OK);
            }
        } catch (Exception e){
            System.out.println("Error has occurred when login | " + e.getMessage());
        }

        return new ResponseEntity<>("Đăng nhập thất bại", HttpStatus.OK);
    }

    @PostMapping("/makekey")
    public void generatePrivateKey(){
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jwtKey = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Private key : "+jwtKey);
    }

}
