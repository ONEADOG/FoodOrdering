package com.it.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.model.TestregisDto;
import com.it.service.TestregisService;

@RestController
public class TestregisController {

	@Autowired 
	private TestregisService testregis;
	
	@GetMapping("/Read")
	public List<TestregisDto> getAll(){
		return testregis.getAll();
	}
	
	@PostMapping("/Create")
	public ResponseEntity<?> save(@ModelAttribute TestregisDto request) throws IOException{
		 testregis.register(request);
		return ResponseEntity.ok().build();
	    }
	@PutMapping("/Update/{testId}")
	public ResponseEntity<?> update(@PathVariable Integer testId,@ModelAttribute TestregisDto request) throws IOException{
		testregis.update(testId, request);
		
		return ResponseEntity.ok("Success");
	}
	}
//public ResponseEntity<?> update(@PathVariable Integer testId, @ModelAttribute TestregisDto request) throws IOException {
//    try {
//        testregis.update(testId, request);
//        return ResponseEntity.ok().body("success");
//    } catch (IOException e) {
//        // จัดการข้อผิดพลาดที่เกิดขึ้น
//        // ตัวอย่างนี้อาจจะเก็บข้อผิดพลาดลงใน Log หรือแสดงข้อความผิดพลาดให้กับผู้ใช้งาน
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
//    }
//}

