package com.it.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="tb_user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="user_age")
	private Integer userAge;
	
	@Column(name="user_phone")
	private String userPhone;
	
	@Column(name="user_image")
	private String userImage;
	
	@Column(name="user_date")
	private Date userDate;
	
	@Column(name="user_type")
	private String userType;
	
	
	@Column(name="user_status")
	private Integer userStatus;

}
