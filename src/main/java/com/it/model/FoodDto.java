package com.it.model;





import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FoodDto {

	private Integer foodId;
	private String foodName;
	private String foodQty;
	private String foodType;
	private String foodImage;
	private Integer promotion;
	private Integer foodStatus;
	private MultipartFile file;
}
