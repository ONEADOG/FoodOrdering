package com.it.model;



import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TestregisDto {

	private  Integer testId;
	private String testImage;
	private String testName;
	private Integer testAge;
	private MultipartFile file;
}
