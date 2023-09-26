package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.FoodEntity;

public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {

}
