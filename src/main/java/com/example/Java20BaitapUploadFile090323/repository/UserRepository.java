package com.example.Java20BaitapUploadFile090323.repository;

import com.example.Java20BaitapUploadFile090323.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Integer countByEmailAndPassword(String email,String pass);
}
