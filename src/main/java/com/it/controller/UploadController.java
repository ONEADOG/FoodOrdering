package com.it.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.it.entity.UploadEntity;
import com.it.model.UploadDto;
import com.it.service.UploadService;

@RestController
@RequestMapping("/Upload")
public class UploadController {

	@Autowired 
	private UploadService upser;
	
	public List<UploadDto> getAll(){
		return upser.getAll();
	}
	@PostMapping("/file")
	public ResponseEntity<UploadEntity> save(@RequestParam("image") MultipartFile file) throws IOException {
		UploadDto upm = new UploadDto();
		upm.setFile(file);
		UploadEntity uploadimage = upser.save(upm);
		return ResponseEntity.ok(uploadimage);
		
		
	}
}
