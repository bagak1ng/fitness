package com.example.CodeJavaApp.repository;

import com.example.CodeJavaApp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query("SELECT u FROM Food u WHERE u.name = ?1")
    public Food findByName(String name);
}
