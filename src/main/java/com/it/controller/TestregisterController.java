//package com.it.controller;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.it.entity.UploadEntity;
//import com.it.model.TestDto;
//import com.it.model.UploadDto;
//import com.it.service.TestregisterService;
//
//@RestController
//public class TestregisterController {
//@Autowired
//private TestregisterService testser;
//
//@PostMapping("/tregister")
//public void save(@ModelAttribute MultipartFile file,@RequestBody TestDto testdto) throws IOException {
//	UploadDto upm = new UploadDto();
//	upm.setFile(file);
//	testser.save(upm,testdto);
//	}
//}
