package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    
}
