package com.it.model;

import java.util.Date;

import lombok.Data;

@Data
public class LoginDto {
	private String username;
	private String password;
	private Integer loginStatus;
	private Integer userId;
	private String firstName;
	private String lastName;
	private Integer userAge;
	private String userPhone;
	private String userImage;
	private Date userDate;
	private Integer roleid;
	private String userType;
	private Integer userStatus;
}
