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
@Table(name="tb_order")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="order_detail")
	private String orderDetail;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="table_name")
	private String tableName;
	
	@Column(name="order_status")
	private Integer orderStatus;
	@Column(name="order_note")
	private String orderNote;
	
	@Column(name="order_qty")
	private Integer orderQty;
	
	@Column(name="orders_id")
	private Integer ordersId;
}
