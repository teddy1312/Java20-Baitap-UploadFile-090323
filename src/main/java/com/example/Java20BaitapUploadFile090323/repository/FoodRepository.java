package com.example.Java20BaitapUploadFile090323.repository;

import com.example.Java20BaitapUploadFile090323.entity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Foods,Integer> {
    List<Foods> findAllBy();
}
