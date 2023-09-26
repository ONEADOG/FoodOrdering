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
@Table(name="tb_payment")
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Integer paymentId;
	
	@Column(name="table_name")
	private String tableName;
	
	@Column(name="guest_qty")
	private Integer guestQty;
	
	@Column(name="promotion")
	private Integer promotion;
	
	@Column(name="total_price")
	private Integer totalPrice;
	
	@Column(name="slip_image")
	private String slipImage;
	
	@Column(name="payment_type")
	private String paymentType;
	
	@Column(name="payment_date")
	private Date paymentDate;
	
	
	@Column(name="payment_status")
	private Integer paymentStatus;
	

	@Column(name="orders_id")
	private Integer ordersId;
}
