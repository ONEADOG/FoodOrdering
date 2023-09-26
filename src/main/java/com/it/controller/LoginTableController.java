package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.it.service.LoginTableService;


@RestController
public class LoginTableController {
@Autowired
private LoginTableService tableser;
	
@PostMapping("/tablelogin/{tableName}")
public ResponseEntity<Object> logint(@PathVariable(name="tableName") String tableName){
	return ResponseEntity.ok(tableser.Login(tableName));
}
}
