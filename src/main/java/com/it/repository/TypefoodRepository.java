package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.FoodEntity;
import com.it.model.FoodDto;

public interface TypefoodRepository extends JpaRepository<FoodEntity, Integer>{
//	List<FoodEntity> findByType(FoodDto foodType); 
}
