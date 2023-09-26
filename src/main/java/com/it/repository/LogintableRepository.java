package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.TableEntity;

@Repository
public interface LogintableRepository extends JpaRepository<TableEntity, Integer>{

	@Query("select t from TableEntity t where t.tableName =? 1  ")
	public TableEntity loginByTablename(String tableName);
	
}
