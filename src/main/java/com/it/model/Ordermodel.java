package com.it.model;

import java.util.Date;



import lombok.Data;

@Data
public class Ordermodel {
private Integer orderId;
	private String orderDetail;
	private Date orderDate;
	private String tableName;
	private Integer orderStatus;
	private String orderNote;
	private Integer orderQty;
	private Integer ordersId;
}
