package com.it.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tb_orderdetail")
public class OrderDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="order_desc")
	private String orderDesc;
	
	@Column(name="order_qty")
	private Integer orderQty;
	
	@Column(name="order_comment")
	private String orderComment;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="table_name")
	private String tableName;
	
	@Column(name="order_status")
	private Integer orderStatus;
}
