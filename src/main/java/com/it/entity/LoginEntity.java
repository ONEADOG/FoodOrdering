package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="tb_login")
public class LoginEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
	private Integer loginId;	
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="login_status")
	private Integer loginStatus;
	@Column(name="roleid")
	private Integer roleid;
	@Column(name="user_id")
	private Integer userId;
}
