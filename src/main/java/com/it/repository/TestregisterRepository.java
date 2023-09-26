package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.TestregisEntity;

public interface TestregisterRepository extends JpaRepository<TestregisEntity, Integer> {

	
}
