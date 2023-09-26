package com.it.model;

import java.util.Date;
import lombok.Data;

@Data
public class OrderDetailDto {
	private Integer orderId;
	private String orderDesc;	
	private Integer orderQty;		
	private String orderComment;		
	private Date orderDate;
	private String tableName;
	private Integer orderStatus;
}
