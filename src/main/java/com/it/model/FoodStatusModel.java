package com.it.model;

import lombok.Data;

@Data 
public class FoodStatusModel {
	private Integer foodId;
	private String foodName;
	private String foodQty;
	private String foodType;
	private String foodImage;
	private Integer promotion;
	private Integer foodStatus;
}
