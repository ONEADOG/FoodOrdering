package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it.entity.TableEntity;

public interface TablelogRepository extends JpaRepository<TableEntity, Integer>{
// set	
//	public TableEntity findByName(String tableName);
}
