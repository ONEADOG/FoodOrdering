package com.it.controller;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.NotFoundException;
import com.it.entity.UserEntity;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.it.entity.UserEntity;
import com.it.model.UserDto;
import com.it.service.Reportservice;
import com.it.service.UserService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userser;
	
	@Autowired
	private Reportservice reportser;
	@GetMapping("/Get")
	public List<UserDto> getAll(){
		return userser.getAll();
	}
	@GetMapping("/Get/{userId}")
	public UserDto getById(@PathVariable Integer userId) {
		return userser.getById(userId);
	}
	
	@GetMapping("/search")
	public List<UserDto> searchUser(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date strDate,
	                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
	    UserDto searchDate = new UserDto();
	    searchDate.setStrDate(strDate); // กำหนดค่า strDate จาก Request Parameter
	    searchDate.setEndDate(endDate);
	    return userser.findByDate(searchDate);
	}
@GetMapping("/date")
public UserDto findByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date userDate) {
	System.out.println(userDate);
	return  userser.findByDate(userDate);
	
}
	
	@PostMapping("/Post")
	public void save(@RequestBody UserDto request) {
		userser.save(request);

	}
	@PutMapping("/Put/{userId}")
	public void update(@PathVariable Integer userId,@RequestBody UserDto request ) {
		userser.update(request, userId);
	}
	@DeleteMapping("/Delete/{userId}")
	public void deleteById(@PathVariable Integer userId) {
		userser.deleteById(userId);
	}
	@GetMapping("/Report/{format}")
	public String generateReport(@PathVariable String format,@DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,@DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo) throws FileNotFoundException, JRException {
		return reportser.exportReport(format,dateFrom,dateTo);
	}

}
