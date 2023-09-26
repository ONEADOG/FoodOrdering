package com.it.model;


import lombok.Data;

@Data
public class TableDto {
	private Integer tableId;

	private String tableName;
//	
//	private Integer guestQty;
	
	private Integer ordersId;

	private Integer tableStatus;
}
