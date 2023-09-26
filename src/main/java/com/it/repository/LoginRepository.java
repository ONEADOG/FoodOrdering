package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
@Query("select t from LoginEntity t where t.username =? 1 and t.password =? 2")
public LoginEntity login(String username,String password);

LoginEntity findByUserId(Integer userId);


}
