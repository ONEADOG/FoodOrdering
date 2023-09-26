package com.it.model;

import java.util.Date;



import lombok.Data;

@Data
public class ReviewDto {

private Integer reviewId;
	private String reviewDetail;
	private Integer reviewFood;
	private Integer reviewService;
	private Date reviewDate; 
}
