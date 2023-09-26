package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer>{

	List<OrderEntity> findByTableName(String tableName);
	
	List<OrderEntity> findByordersId(Integer ordersId);
}
