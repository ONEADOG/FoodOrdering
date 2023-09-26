package com.it.model;




import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EditDto {


	private Integer userId;
	private String firstName;
	private String lastName;
	private Integer userAge;
	private String userPhone;
	private String userImage;

	private Integer roleId;
	private String userType;
	private Integer userStatus;
	private MultipartFile file;
}

