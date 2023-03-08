package com.example.Java20BaitapUploadFile090323.utils;

import com.example.Java20BaitapUploadFile090323.payload.DataResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class JwtUtils {

    private long expiredTime = 8 * 60 * 60 * 1000;

    @Value("${jwt.privateKey}")
    private String privateKey;

    public DataResponse generateToken(String username){
        SecretKey key = Keys.hmacShaKeyFor(privateKey.getBytes());
        Calendar calendar = new GregorianCalendar();
        long currentDateByMs = calendar.getTimeInMillis() + expiredTime;
        Date expiredTime = new Date(currentDateByMs);

        String jwt = Jwts.builder()
                        .setSubject(username)
                        .signWith(key)
                        .setExpiration(expiredTime)
                        .compact();

        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatus(200);
        dataResponse.setDescription("Tạo token thành công");
        dataResponse.setData(jwt);

        System.out.println("New token: "+jwt);

        return dataResponse;
    }

    public String verifyToken(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(privateKey.getBytes());
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e){
            System.out.println("Error has occurred when verify token | " + e.getMessage());
            return null;
        }
    }
}
