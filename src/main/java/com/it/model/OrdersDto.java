package com.it.model;

import java.util.Date;


import lombok.Data;

@Data 
public class OrdersDto {
	private Integer ordersId;
	private Integer guestQty;
	private Integer guestChild;
	private Integer totalGuest;
	private Integer guestPromotion;
	private Integer totalPrice;
	private String tableName;
	private Date orderDate;
	private Integer orderStatus;
	private String sourcesforQr;
}
