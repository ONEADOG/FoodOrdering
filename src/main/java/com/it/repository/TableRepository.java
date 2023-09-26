package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.TableEntity;

public interface TableRepository extends JpaRepository<TableEntity, Integer> {
	
	TableEntity findByTableName(String tableName);

}
