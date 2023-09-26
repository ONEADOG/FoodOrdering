package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.UploadEntity;

@Repository
public interface UploadRepository extends JpaRepository<UploadEntity, Integer> {

}
