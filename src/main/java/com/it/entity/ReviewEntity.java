package com.it.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_review")
public class ReviewEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="review_id")
	private Integer reviewId;
	
	@Column(name="review_detail")
	private String reviewDetail;
	
	@Column(name="review_food")
	private Integer reviewFood;
	
	@Column(name="review_service")
	private Integer reviewService;
	
	@Column(name="review_date")
	private Date reviewDate; 
}
