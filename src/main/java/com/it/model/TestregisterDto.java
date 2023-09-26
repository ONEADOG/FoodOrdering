package com.it.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TestregisterDto {
	private Integer id;
	private String imagePath;
	private Date imageDate;
	private MultipartFile file;
	private String names;
	private Integer number;
}
