package com.it.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ReportDto {
	private Integer paymentId;
	private String tableName;
	private Integer guestQty;
	private Integer promotion;
	private Integer totalPrice;
	private String slipImage;
	private String paymentType;
	private Date paymentDate;
	private Integer paymentStatus;
}
