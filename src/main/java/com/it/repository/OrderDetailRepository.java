package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer>{
	
	

}
