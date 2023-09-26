package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.FoodEntity;

@Repository
public interface StatRepository extends JpaRepository<FoodEntity, Integer>{
 @Query("SELECT SUM(f.promotion) FROM FoodEntity f")
 Integer totalpromotion();
}
