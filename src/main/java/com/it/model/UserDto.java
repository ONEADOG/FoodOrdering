package com.it.model;

import java.util.Date;



import lombok.Data;

@Data
public class UserDto {
	private Integer userId;
	private String firstName;
	private String lastName;
	private Integer userAge;
	private String userPhone;
	private String userImage;
	private Date userDate;
	private String userType;
	private Integer loginId;
	private Integer userStatus;
	private Date strDate;
	private Date endDate;
}
