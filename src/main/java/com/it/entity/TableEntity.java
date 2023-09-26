package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_table")
public class TableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="table_id")
	private Integer tableId;
	
	@Column(name="table_name")
	private String tableName;
//	
//	@Column(name="guest_qty")
//	private Integer guestQty;
	
	@Column(name="orders_id")
	private Integer ordersId;
	
	@Column(name="table_status")
	private Integer tableStatus;
}
