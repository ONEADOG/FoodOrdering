package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.FoodTypeEntity;

@Repository
public interface FoodtypeRepository extends JpaRepository<FoodTypeEntity, Integer>{
}
