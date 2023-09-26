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
@Table(name="tb_orders")
public class OrdersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orders_id")
	private Integer ordersId;
	
	@Column(name="guest_qty")
	private Integer guestQty;
	
	@Column(name="guest_child")
	private Integer guestChild;
	
	@Column(name="total_guest")
	private Integer totalGuest;
	
	@Column(name="guest_promotion")
	private Integer guestPromotion;
	
	@Column(name="total_price")
	private Integer totalPrice;
	
	@Column(name="table_name")
	private String tableName;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="order_status")
	private Integer orderStatus;
	
	@Column(name="sourcesfor_qr")
	private String sourcesforQr;
}
