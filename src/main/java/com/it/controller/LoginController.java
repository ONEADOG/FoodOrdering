package com.it.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.EditDto;
import com.it.model.RegisterDto;
import com.it.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService logser;
	
	@PostMapping("/login/{username}/{password}")
	public ResponseEntity<Object> login(@PathVariable(name="username") String username,@PathVariable(name="password") String password){
		return ResponseEntity.ok(logser.login(username, password));
	}
	 
	@GetMapping("/Getuser")
	public List<RegisterDto> getAll(){
		return logser.getAll();	
		}
	@GetMapping("/Getuser/{userId}")
	public RegisterDto getById(@PathVariable Integer userId) {
		return logser.getById(userId);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> save(@ModelAttribute RegisterDto request)throws IOException{
		logser.addUser(request);
		return ResponseEntity.ok("Succes!?");
	}
	
	@PutMapping("/User/{userId}")
	public ResponseEntity<?> update(@PathVariable Integer userId ,@ModelAttribute EditDto request)throws IOException{
		logser.editUser(userId, request);
		return ResponseEntity.ok("Succes!?");
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable Integer userId){
		logser.deleteById(userId);
		return ResponseEntity.ok("Delete Success?");
	}
	@DeleteMapping("/deleteBy/{userId}")
	public ResponseEntity<?> deleteByIduser(@PathVariable Integer userId){
	try {	logser.deleteByIduser(userId);
		return ResponseEntity.ok("Delete Success?");
	}catch(Exception e) {
		 return new ResponseEntity<>("Error deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
