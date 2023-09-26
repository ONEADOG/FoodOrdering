package com.it.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	@Query("SELECT f FROM UserEntity f WHERE f.userDate BETWEEN :strDate AND :endDate")
	List<UserEntity> findDateBetweenDate(@Param("strDate") Date strDate ,@Param("endDate") Date endDate);
	
	@Query("SELECT f FROM UserEntity f WHERE f.userDate = :userDate ")
	public UserEntity findByDate(@Param("userDate") Date userDate);
	
//
//	 public UserEntity findByAge(Integer userAge);
}
