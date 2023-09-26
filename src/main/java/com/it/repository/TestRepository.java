package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it.entity.OrderEntity;


public interface TestRepository extends JpaRepository<OrderEntity, Integer> {
	@Query(value =  "SELECT SUBSTRING_INDEX(order_detail, ' ',1) AS keyword, COUNT(*) AS popularity " +
	           "FROM tb_order  " +
	           "GROUP BY keyword " +
	           "ORDER BY popularity DESC"
	       ,
	           nativeQuery = true)
	 List<Object[]> findTop3PopularKeywords();
}
