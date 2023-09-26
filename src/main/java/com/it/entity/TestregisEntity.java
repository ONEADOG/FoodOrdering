package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_testregis")
public class TestregisEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_id")
	private Integer testId;
	
	@Column(name="test_image")
	private String testImage;
	
	@Column(name="test_name")
	private String testName;
	
	@Column(name="test_age")
	private Integer testAge;
}
